package br.com.i3focus.producer.application.controller;

import org.joda.time.DateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class SignalRequest {
    @NotNull
    @NotBlank
    private String exchange;
    @NotNull
    @NotBlank
    private String ticker;
    @NotNull
    private DateTime date;
    @NotNull
    @NotBlank
    private String type;
    @NotNull
    @PositiveOrZero
    private BigDecimal price;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "  exchange='" + exchange + '\'' +
                ", ticker='" + ticker + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", price=" + price +
                "  }";
    }
}
