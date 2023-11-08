package com.picpay.capturechannels.adapter.tcp.config

import com.picpay.capturechannels.adapter.tcp.service.TcpAdapterService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.annotation.Transformer
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.channel.ExecutorChannel
import org.springframework.integration.ip.tcp.TcpReceivingChannelAdapter
import org.springframework.integration.ip.tcp.TcpSendingMessageHandler
import org.springframework.integration.ip.tcp.connection.AbstractConnectionFactory
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory
import org.springframework.integration.ip.tcp.serializer.ByteArrayLengthHeaderSerializer
import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor
import java.util.concurrent.ThreadPoolExecutor

@Configuration
open class TcpConfig {
    @Value("\${server-thread-pool.core-size}")
    private val threadPoolCoreSize = 0

    @Value("\${server-thread-pool.max-size}")
    private val threadPoolMaxSize = 0

    @Value("\${server-thread-pool.queue-capacity}")
    private val queueCapacity = 0

    @Value("\${server-thread-pool.keep-alive-seconds}")
    private val keepAliveSeconds = 0

    @Autowired
    private lateinit var tcpAdapterService: TcpAdapterService

    /**
     * Configurar o Serializer do Header da mensagem.
     *
     * @param maxMessageSize Tamanho máximo da mensagem
     * @return A instância de ByteArrayLengthHeaderSerializer contendo as configurações especificadas.
     */
    @Bean(name = ["tcpByteArrayLengthHeaderSerializer"])
    open fun serializer(@Value("\${tcp.message.size.max}") maxMessageSize: Int?): ByteArrayLengthHeaderSerializer {
        val tcpByteArrayLengthHeaderSerializer = ByteArrayLengthHeaderSerializer(MESSAGE_HEADER_SIZE)
        tcpByteArrayLengthHeaderSerializer.maxMessageSize = maxMessageSize!!
        return tcpByteArrayLengthHeaderSerializer
    }
    fun String.PicpayString(): String {
        return this.toString().uppercase()
    }
    /**
     * Cria a instância do Factory de conexão do server.
     *
     * @param tcpPortNumber O número da porta.
     * @param backlogSize Tamanho do backlog.
     * @return A fábrica de conexão do server.
     */
    @Bean(name = [TCP_SERVER])
    open fun tcpServerFactory(
        @Value("\${tcp.port}") tcpPortNumber: Int,
        @Value("\${tcp.factory.connection.backlog}") backlogSize: Int,
        @Qualifier("tcpBridgeTaskExecutor") tcpBridgeTaskExecutor: Executor): MeteredTcpNetServerConnectionFactory {
        LOGGER.info("Criando a fábrica ${backlogSize} de conexão do server.")
        val factoryBean = MeteredTcpNetServerConnectionFactory(tcpPortNumber)
        factoryBean.serializer = serializer(null)
        factoryBean.deserializer = serializer(null)
        factoryBean.isSoKeepAlive = true
        factoryBean.backlog = backlogSize
        factoryBean.isSingleUse = false
        return factoryBean
    }

    /**
     * Cria o adapter do canal de recepção da mensagem.
     *
     * @param tcpServerFactory A fabrica de conexão com o server que foi previamente configurada.
     * @return A instância de TcpReceivingChannelAdapter com as configurações específicas.
     */
    @Bean(name = ["inAdapter.tcpServer"])
    open fun fromTcpAdapter(@Qualifier(TCP_SERVER) tcpServerFactory: AbstractServerConnectionFactory?): TcpReceivingChannelAdapter {
        LOGGER.info("Criando o adapter do canal de recepção da mensagem.")
        val adapter = TcpReceivingChannelAdapter()
        adapter.setConnectionFactory(tcpServerFactory)
        adapter.setOutputChannelName(INBOUND_CHANNEL)
        return adapter
    }

    /**
     * Criação do Canal da Mensagem.
     *
     * @return A instância de MessageChannel.
     */
    @Bean(name = [INBOUND_CHANNEL])
    open fun fromTcp(@Qualifier("tcpBridgeTaskExecutor") tcpBridgeTaskExecutor: Executor): MessageChannel {
        return ExecutorChannel(tcpBridgeTaskExecutor)
    }

    /**
     * Configurações do MessageHandler do Tcp.
     *
     * @param tcpServerFactory A instância que contém a conexão server com Tcp.
     *
     * @return A instância do MessageHandler do Tcp.
     */
    @ServiceActivator(inputChannel = OUTBOUND_CHANNEL, requiresReply = "true", async = "true")
    @Bean
    open fun toTcpAdapterTcp(@Qualifier(TCP_SERVER) tcpServerFactory: AbstractConnectionFactory?) =
        try {
            LOGGER.info("Criando o MessageHandler do TCP.")
            //output message in println
            LOGGER.info("lendo output message in println: %S", OUTBOUND_CHANNEL.toByteArray())
            val tcpOutboundAdp = TcpSendingMessageHandler()
            tcpOutboundAdp.setConnectionFactory(tcpServerFactory)
            tcpOutboundAdp.isLoggingEnabled = false
            tcpOutboundAdp
        } catch (e: Exception) {
            LOGGER.error(MESSAGE_TCP_UNABLE_FIND_SOCKET, e)
            throw RuntimeException(e)
        }

    @Bean(DISCARD_CHANNEL)
    open fun noResponseChannel(): DirectChannel {
        return DirectChannel()
    }

    @ServiceActivator(inputChannel = DISCARD_CHANNEL)
    fun noResponse(mensagem: String?) {
        if (LOGGER.isDebugEnabled) {
            LOGGER.debug(MESSAGE_DESCARTADA, mensagem)
        }
    }

    /**
     * Realiza a transformação da mensagem.
     *
     * @param bytes
     * @return A mensagem alterada.
     */
    @Transformer(inputChannel = INBOUND_CHANNEL, outputChannel = OUTBOUND_CHANNEL)
    fun service(message: Message<ByteArray>): Message<ByteArray> {
        return tcpAdapterService!!.executeProcessors(message)
    }

    @EventListener
    fun eventListenerTcpUnableFindOutboundSocketEvent(t: TcpUnableFindOutboundSocketEvent) {
        if (LOGGER.isDebugEnabled) {
            LOGGER.debug(MESSAGE_TCP_UNABLE_FIND_SOCKET, t.payload)
        }
    }

    /**
     * Criação do Canal da Mensagem.
     *
     * @return A instância de MessageChannel.
     */
    @Bean(name = [OUTBOUND_CHANNEL])
    open fun toTcp(
        @Qualifier("tcpBridgeTaskExecutorOutbound") tcpBridgeTaskExecutorOutbound: Executor): MessageChannel {
        return ExecutorChannel(tcpBridgeTaskExecutorOutbound)
    }

    @Bean(name = ["tcpBridgeTaskExecutor"])
    open fun tcpBridgeTaskExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = threadPoolCoreSize
        executor.maxPoolSize = threadPoolMaxSize
        executor.setQueueCapacity(queueCapacity)
        executor.setRejectedExecutionHandler(ThreadPoolExecutor.CallerRunsPolicy())
        executor.initialize()
        return executor
    }

    @Bean(name = ["tcpBridgeTaskExecutorOutbound"])
    open fun tcpBridgeTaskExecutorOutbound(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = threadPoolCoreSize
        executor.maxPoolSize = threadPoolMaxSize
        executor.setQueueCapacity(queueCapacity)
        executor.setRejectedExecutionHandler(ThreadPoolExecutor.CallerRunsPolicy())
        executor.initialize()
        return executor
    }

    companion object {
        private const val MESSAGE_HEADER_SIZE = 4
        private const val TCP_SERVER = "tcpServer"
        private const val OUTBOUND_CHANNEL = "outboundChannel.tcp"
        private const val INBOUND_CHANNEL = "inboundChannel.tcp"
        private const val DISCARD_CHANNEL = "discardChannel.tcp"
        private const val MESSAGE_DESCARTADA = "Mensagem descartada - Payload {}"
        private const val MESSAGE_TCP_UNABLE_FIND_SOCKET = "Tcp Unable to find outbound socket - Payload {}"
        private val LOGGER = LoggerFactory.getLogger(TcpConfig::class.java)
    }
}
