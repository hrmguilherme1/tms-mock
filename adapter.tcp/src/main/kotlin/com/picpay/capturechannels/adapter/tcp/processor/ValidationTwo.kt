package com.picpay.capturechannels.adapter.tcp.processor

import com.picpay.capturechannels.adapter.tcp.annotation.TcpProcessor
import com.picpay.capturechannels.adapter.tcp.service.TcpAdapterService
import com.picpay.capturechannels.core.businessprocessor.BusinessProcessor
import com.picpay.capturechannels.core.model.BusinessProcessContext
import org.jpos.iso.ISOException
import org.jpos.iso.ISOMsg
import org.jpos.iso.packager.GenericPackager
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@TcpProcessor
@Component
@Order(2)
class ValidationTwo : BusinessProcessor {

    override fun process(context: BusinessProcessContext) {
        //unpack iso message context.mensagemTransacaoOriginal
        val isoMsg = bytesToISOMsg(context.mensagemTransacaoOriginal)
        println("isoMsg: ${isoMsg  })")
        val dto = isoMsgToDto(isoMsg)
        println("dto: ${dto.bit70  })")
        if (dto.codMsg == "0800") {
            when (dto.bit70) {
                "001" -> {
                    println("ESTOU_AQUI_FLUXO_1")
                    // De acordo com o Fluxo 1, quando o bit70 é "001", o processo de Logon-Carga de Tabelas foi finalizado.
                    context.mensagemTransacaoOriginal = dtoToIsoMessage("0810", dto.bit13!!, dto.bit11!!, dto.bit12!!, "800",dto.bit07!!)
                }
                "800" -> {
                    println("ESTOU_AQUI_FLUXO_2")
                    // De acordo com o Fluxo 2, quando o bit70 é "800", a primeira resposta do autorizador deve ter bit70 como "801".
                    context.mensagemTransacaoOriginal = dtoToIsoMessage("0810", dto.bit13!!, dto.bit11!!, dto.bit12!!, "801",dto.bit07!!)
                }
            }
        } else if (dto.codMsg == "0810" && dto.bit70!!.toInt() in 801..999) {
            println("ESTOU_AQUI_FLUXO_3")
            // De acordo com o Fluxo 3, o autorizador responde incrementando o valor do bit70 até chegar a "999".
            context.mensagemTransacaoOriginal = dtoToIsoMessage("0810", dto.bit13!!, dto.bit11!!, dto.bit12!!, dto.bit70!!.toInt().plus(1).toString(),dto.bit07!!)
        } else if (dto.codMsg == "0810" && dto.bit70 == "999") {
            println("ESTOU_AQUI_FLUXO_4")
            // De acordo com o Fluxo 3, quando o bit70 é "999", indica que o processo de Carga de Tabelas foi finalizado.
            context.mensagemTransacaoOriginal = dtoToIsoMessage("0810", dto.bit13!!, dto.bit11!!, dto.bit12!!, "999",dto.bit07!!)
        } else {
            println("ESTOU_AQUI_FLUXO_5")
            println("dto.codMsg: ${dto.bit70  })")
            // Resposta padrão para mensagens inesperadas.
            context.mensagemTransacaoOriginal = dtoToIsoMessage("0809", dto.bit13!!, dto.bit11!!, dto.bit12!!, "001",dto.bit07!!)
        }

    }

    fun dtoToIsoMessage(msg: String, bit13: String,bit11: String,bit12: String,bit70:String,bit7: String): ByteArray {
        val packager = try {
            val classLoader = Thread.currentThread().contextClassLoader
            val inputStream = classLoader.getResourceAsStream("packager.xml")
            GenericPackager(inputStream)
        } catch (e: ISOException) {
            e.printStackTrace()
            return "MSG INVALIDA".toByteArray()
        }

        val isoMsg = ISOMsg()
        isoMsg.setPackager(packager)

        // Define MTI
        isoMsg.setMTI(msg)

        isoMsg.set(3, "910000");
        isoMsg.set(7, bit7);
        isoMsg.set(11, bit11);
        isoMsg.set(12, bit12);
        isoMsg.set(13, bit13);
        isoMsg.set(42, "000000000000001");
        isoMsg.set(47, "00100800000001");
        isoMsg.set(61, "04.31");
        isoMsg.set(70, bit70);
        val messageBytes: ByteArray = isoMsg.pack()
        return messageBytes
    }

    fun isoMsgToDto(isoMsg: ISOMsg): ResponseDTO {
        val constructor = ResponseDTO::class.java.getConstructors()[0]
        val parameters = constructor.parameterAnnotations.flatMap { annotations ->
            annotations.filterIsInstance<TcpAdapterService.IsoField>().map { annotation ->
                isoMsg.getString(annotation.value)
            }
        }.toTypedArray()
        return constructor.newInstance(*parameters) as ResponseDTO
    }

    private fun bytesToISOMsg(bytes: ByteArray): ISOMsg {
        LoggerFactory.getLogger(this.javaClass).info("payload: ${String(bytes)}")
        LoggerFactory.getLogger(this.javaClass).info("size payload: ${bytes.size}")
        require(bytes.size >= 10) { "Mensagem muito curta para ser uma mensagem ISO válida: ${String(bytes)}" }

        val mti = String(bytes.sliceArray(0..3))
        require(mti.matches(Regex("[0-9]{4}"))) { "MTI inválido: $mti" }

        val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream("packager.xml")
        val packager = GenericPackager(inputStream)
        val isoMsg = ISOMsg()
        isoMsg.packager = packager
        try {
            isoMsg.unpack(bytes)
        } catch (e: ISOException) {
            println("Erro ao desempacotar mensagem ISO: ${String(bytes)} erro: {${e.message}}")
            throw e
        }
        return isoMsg
    }
}
