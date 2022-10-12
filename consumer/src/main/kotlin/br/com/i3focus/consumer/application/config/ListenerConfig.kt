package br.com.i3focus.consumer.application.config

import br.com.i3focus.consumer.application.listeners.SignalsCreatedEventListener
import br.com.i3focus.consumer.domain.SignalRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ListenerConfig {

    @Bean
    fun signalsCreatedEventListener(signalRepository: SignalRepository) =
        SignalsCreatedEventListener(signalRepository)
}
