package com.picpay.capturechannels.core.service

interface CoreService<I, O> {
    fun executeProcessors(request: I, message: O): O
}
