package com.picpay.capturechannels.adapter.tcp.service

import com.picpay.capturechannels.adapter.tcp.annotation.TcpProcessor

import com.picpay.capturechannels.core.businessprocessor.BusinessProcessor
import com.picpay.capturechannels.core.model.BusinessProcessContext
import com.picpay.capturechannels.core.service.CoreService
import org.slf4j.LoggerFactory
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.Message
import org.springframework.stereotype.Service

@Service
class TcpCoreService(@TcpProcessor private val processors: List<BusinessProcessor>) : CoreService<BusinessProcessContext, Message<ByteArray>> {

    override fun executeProcessors(businessRequest: BusinessProcessContext, message: Message<ByteArray>): Message<ByteArray> {
        LoggerFactory.getLogger(TcpCoreService::class.java).info("TcpCoreService.executeProcessors: {message: ${message.payload}}")
        processors.forEach { processor -> processor.process(businessRequest) }

        return MessageBuilder.withPayload(businessRequest.mensagemTransacaoOriginal).copyHeaders(message.headers).build()
    }
}
