package br.com.i3focus.consumer.application.listeners

import br.com.i3focus.consumer.domain.SignalRepository
import org.slf4j.LoggerFactory
import java.util.function.Consumer

class SignalsCreatedEventListener(private val signalRepository: SignalRepository) : Consumer<SignalMessage> {
    private val logger = LoggerFactory.getLogger(SignalsCreatedEventListener::class.java)

    override fun accept(message: SignalMessage) {
        try {
            message.toSignal()
                .let { signalRepository.save(it) }
                .also { logger.info("Signal created successfully: {}", it) }
        } catch (ex: Exception) {
            logger.error("Error to process signal message. [{}]", ex.message)
            throw ex
        }
    }
}
