package br.com.i3focus.consumer.application

import br.com.i3focus.consumer.domain.Signal
import br.com.i3focus.consumer.domain.SignalRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/signals")
class SignalController(private val signalRepository: SignalRepository) {
    @GetMapping
    fun getAllPageableSignals(
        @PageableDefault(
            page = 0,
            size = 20,
            sort = ["date"],
            direction = Sort.Direction.DESC
        )
        pageable: Pageable
    ): ResponseEntity<Page<Signal>> =
        signalRepository.findAll(pageable)
            .let { ResponseEntity.ok(it) }
}
