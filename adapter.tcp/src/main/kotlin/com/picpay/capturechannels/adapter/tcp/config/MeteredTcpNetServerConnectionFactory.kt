package com.picpay.capturechannels.adapter.tcp.config

import org.springframework.integration.ip.tcp.connection.TcpNetServerConnectionFactory
import org.springframework.stereotype.Service

class MeteredTcpNetServerConnectionFactory(port: Int) : TcpNetServerConnectionFactory(port)
