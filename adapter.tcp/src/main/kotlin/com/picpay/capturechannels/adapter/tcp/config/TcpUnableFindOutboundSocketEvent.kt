package com.picpay.capturechannels.adapter.tcp.config

import org.springframework.integration.ip.event.IpIntegrationEvent
import org.springframework.messaging.MessagingException
import org.springframework.stereotype.Service

class TcpUnableFindOutboundSocketEvent(source: Any?, cause: MessagingException) :
    IpIntegrationEvent(source, cause) {
    /**
     * Obtém o valor do atributo payload
     *
     * @return O valor do atributo payload
     */
    val payload: Any

    init {
        payload = cause.failedMessage!!.payload
    }

    companion object {
        private const val serialVersionUID = -8833319070721177496L
    }
}
