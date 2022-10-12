package br.com.i3focus.producer.application.producer;

import br.com.i3focus.producer.application.controller.SignalRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SignalsCreatedEventProducer {
    private static final Logger logger = LoggerFactory.getLogger(SignalsCreatedEventProducer.class);
    private static final String CHANNEL = "signalsCreatedEventProducer-out-0";
    private final StreamBridge streamBridge;

    public SignalsCreatedEventProducer(final StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void produceSignalCreatedEvent(final SignalRequest message) {
        logger.info("Starting to send signal message: {}", message);

        streamBridge.send(CHANNEL, message);
    }
}
