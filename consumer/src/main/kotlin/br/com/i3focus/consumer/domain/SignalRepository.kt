package br.com.i3focus.consumer.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SignalRepository {
    fun save(signal: Signal): Signal
    fun findAll(pageable: Pageable): Page<Signal>
}
