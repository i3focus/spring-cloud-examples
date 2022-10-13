package br.com.i3focus.consumer.application.listeners;

import br.com.i3focus.consumer.domain.Signal;
import br.com.i3focus.consumer.domain.SignalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class SignalCreatedEventListener implements Consumer<SignalMessage> {
    private static final Logger logger = LoggerFactory.getLogger(SignalCreatedEventListener.class);
    private final SignalRepository repository;

    public SignalCreatedEventListener(final SignalRepository repository) {
        this.repository = repository;
    }

    @Override
    public void accept(final SignalMessage message) {
        try {
            final Signal signal = repository.save(message.toSignal());
            logger.info("Signal created successfully: {}", signal);
        } catch (final Exception ex) {
            logger.error("Error to process signal message. [{}]", ex.getMessage());
            throw new SignalConsumerException(ex.getMessage());
        }
    }
}
