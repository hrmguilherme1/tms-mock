package com.picpay.capturechannels.adapter.tcp.processor

import com.picpay.capturechannels.adapter.tcp.annotation.TcpProcessor
import com.picpay.capturechannels.core.businessprocessor.BusinessProcessor
import com.picpay.capturechannels.core.model.BusinessProcessContext
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component


@TcpProcessor
@Component
@Order(1)
class Validation : BusinessProcessor {
    override fun process(context: BusinessProcessContext) {
        context.mensagemTransacaoOriginal = context.mensagemTransacaoOriginal
    }
}
