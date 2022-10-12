package br.com.i3focus.consumer.application.listeners

import br.com.i3focus.consumer.domain.Signal
import org.joda.time.DateTime
import java.math.BigDecimal

data class SignalMessage(
    val exchange: String,
    val ticker: String,
    val date: DateTime,
    val type: String,
    val price: BigDecimal
) {
    fun toSignal() = Signal(
        exchange = exchange,
        ticker = ticker,
        date = date,
        type = type,
        price = price
    )
}