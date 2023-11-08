package com.picpay.capturechannels.core.service

import com.picpay.capturechannels.core.businessprocessor.BusinessProcessor
import com.picpay.capturechannels.core.model.BusinessProcessContext
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class CoreServiceImpl(private val processors: List<BusinessProcessor>) : CoreService<BusinessProcessContext, Message<ByteArray>> {

    @Override
    override fun executeProcessors(businessRequest: BusinessProcessContext, message: Message<ByteArray>) : Message<ByteArray>{
        processors.forEach { it.process(businessRequest) }
        return MessageBuilder.withPayload(businessRequest.mensagemTransacaoOriginal).build()
    }
}

