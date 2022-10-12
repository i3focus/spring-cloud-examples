package br.com.i3focus.consumer.resource

import br.com.i3focus.consumer.domain.Signal
import br.com.i3focus.consumer.domain.SignalRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class SignalRepositoryImpl(
    private val signalRepository: SignalDataRepository
) : SignalRepository {

    override fun save(signal: Signal): Signal =
        SignalDocument.from(signal)
            .let { signalRepository.insert(it) }
            .let { SignalDocument.to(it) }

    override fun findAll(pageable: Pageable): Page<Signal> =
        signalRepository.findAll(pageable).map { SignalDocument.to(it) }
}
