package br.com.i3focus.consumer.domain

import io.azam.ulidj.ULID
import org.joda.time.DateTime
import java.math.BigDecimal

data class Signal(
    val id: String = ULID.random(),
    val exchange: String,
    val ticker: String,
    val date: DateTime,
    val type: String,
    val price: BigDecimal
)
