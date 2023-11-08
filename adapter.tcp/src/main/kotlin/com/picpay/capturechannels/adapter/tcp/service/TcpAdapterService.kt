package com.picpay.capturechannels.adapter.tcp.service

import com.picpay.capturechannels.core.model.BusinessProcessContext
import com.picpay.capturechannels.core.service.CoreService
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.Message
import org.springframework.stereotype.Service

@Service
class TcpAdapterService(coreService: TcpCoreService) {
    private val coreService: CoreService<BusinessProcessContext, Message<ByteArray>>
    annotation class IsoField(val value: Int)
    init {
        this.coreService = coreService
    }

    fun executeProcessors(message: Message<ByteArray>): Message<ByteArray> {
        if (message.payload.size <= 0) {
            return MessageBuilder.withPayload(ByteArray(0)).build()
        }

        val businessRequest = BusinessProcessContext(message.payload)
        return coreService.executeProcessors(businessRequest, message)
    }
}
