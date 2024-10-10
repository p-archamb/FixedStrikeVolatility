package com.example.FixedStrikeVolatility.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class that represents a price and underlying price for a options instrument. It is mapped to the option_prices
 * table in the postgres database.
 */
@Entity
@Table(name = "option_prices")
public class OptionPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long instrumentId;
    private BigDecimal underlyingPrice;
    private BigDecimal price;
    private LocalDateTime timestamp;

    public OptionPrice() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getInstrumentId() {
        return instrumentId;
    }
    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }
    public BigDecimal getUnderlyingPrice() {
        return underlyingPrice;
    }
    public void setUnderlyingPrice(BigDecimal underlyingPrice) {
        this.underlyingPrice = underlyingPrice;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
