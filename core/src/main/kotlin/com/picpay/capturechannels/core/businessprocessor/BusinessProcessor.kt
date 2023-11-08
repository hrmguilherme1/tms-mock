package com.picpay.capturechannels.core.businessprocessor

import com.picpay.capturechannels.core.model.BusinessProcessContext

interface BusinessProcessor {
    fun process(context: BusinessProcessContext)
}
