package com.picpay.capturechannels.adapter.tcp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.integration.annotation.IntegrationComponentScan
import org.springframework.integration.config.EnableIntegration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication(scanBasePackages = ["com.picpay.capturechannels"])
@ComponentScan("com.picpay.capturechannels")
@EnableIntegration
@EnableScheduling
@EnableAsync
@IntegrationComponentScan
open class TcpApplication

fun main(args: Array<String>) {
    runApplication<TcpApplication>(*args)
}

@Bean
fun propertyConfig(): PropertySourcesPlaceholderConfigurer {
    return PropertySourcesPlaceholderConfigurer()
}
