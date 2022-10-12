package br.com.i3focus.producer.application.controller;

import br.com.i3focus.producer.application.producer.SignalsCreatedEventProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/signals")
public class SignalController {
    private final SignalsCreatedEventProducer producer;

    public SignalController(SignalsCreatedEventProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<Void> createSignals(@RequestBody @Validated SignalRequest message) {
        Objects.requireNonNull(message, "Signal is mandatory!");

        producer.produceSignalCreatedEvent(message);

        return ResponseEntity.accepted().build();
    }
}
