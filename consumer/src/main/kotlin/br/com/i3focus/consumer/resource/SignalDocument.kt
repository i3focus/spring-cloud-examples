package br.com.i3focus.consumer.resource

import br.com.i3focus.consumer.domain.Signal
import org.joda.time.DateTime
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document
data class SignalDocument(
    @Id
    val id: String,
    val exchange: String,
    val ticker: String,
    val date: DateTime,
    val type: String,
    val price: BigDecimal
){
    companion object {
        fun from(signal: Signal) = SignalDocument(
            id = signal.id,
            exchange = signal.exchange,
            ticker = signal.ticker,
            date = signal.date,
            type = signal.type,
            price = signal.price
        )

        fun to(document: SignalDocument) = Signal(
            id = document.id,
            exchange = document.exchange,
            ticker = document.ticker,
            date = document.date,
            type = document.type,
            price = document.price
        )
    }
}
