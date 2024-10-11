package com.example.FixedStrikeVolatility.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entity class that represents an options instrument. It is mapped to the instruments
 * table in the postgres database.
 */
@Entity
@Table(name = "instruments")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String instrumentType;
    @Column(name = "strike")
    private BigDecimal strike;
    @Column(name = "option_type")
    private Character optionType;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    private LocalDateTime lastUpdated;

    public Instrument() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getInstrumentType() {
        return instrumentType;
    }
    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }
    public BigDecimal getStrike() {
        return strike;
    }
    public void setStrike(BigDecimal strike) {
        this.strike = strike;
    }
    public Character getOptionType() {
        return optionType;
    }
    public void setOptionType(Character optionType) {
        this.optionType = optionType;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
