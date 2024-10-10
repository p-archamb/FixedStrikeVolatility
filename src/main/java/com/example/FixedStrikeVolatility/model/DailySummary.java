package com.example.FixedStrikeVolatility.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

/**
 * Entity class that represents a daily summary of options data. It is mapped to the daily summary
 * table in the postgres database.
 */
@Entity
@Table(name = "daily_summary")
public class DailySummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "instrument_id")
    private Long instrumentId;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @Column(name = "opening_price")
    private BigDecimal openingPrice;
    @Column(name = "closing_price")
    private BigDecimal closingPrice;
    @Column(name = "previous_closing_price")
    private BigDecimal previousClosingPrice;
    @Column(name = "high_price")
    private BigDecimal highPrice;
    @Column(name = "low_price")
    private BigDecimal lowPrice;
    @Column(name = "opening_iv")
    private BigDecimal openingIV;
    @Column(name = "closing_iv")
    private BigDecimal closingIV;
    @Column(name = "previous_closing_iv")
    private BigDecimal previousClosingIv;
    @Column(name = "high_iv")
    private BigDecimal highIv;
    @Column(name = "low_iv")
    private BigDecimal lowIv;

    public DailySummary() {}

    public DailySummary(Long instrumentId, LocalDate date) {
        this.instrumentId = instrumentId;
        this.date = date;
    }

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
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public BigDecimal getOpeningPrice() {
        return openingPrice;
    }
    public void setOpeningPrice(BigDecimal openingPrice) {
        this.openingPrice = openingPrice;
    }
    public BigDecimal getClosingPrice() {
        return closingPrice;
    }
    public void setClosingPrice(BigDecimal closingPrice) {
        this.closingPrice = closingPrice;
    }
    public BigDecimal getPreviousClosingPrice() {
        return previousClosingPrice;
    }
    public void setPreviousClosingPrice(BigDecimal previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }
    public BigDecimal getHighPrice() {
        return highPrice;
    }
    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }
    public BigDecimal getLowPrice() {
        return lowPrice;
    }
    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }
    public BigDecimal getOpeningIV() {
        return openingIV;
    }
    public void setOpeningIV(BigDecimal openingIV) {
        this.openingIV = openingIV;
    }
    public BigDecimal getClosingIV() {
        return closingIV;
    }
    public void setClosingIV(BigDecimal closingIV) {
        this.closingIV = closingIV;
    }
    public BigDecimal getPreviousClosingIv() {
        return previousClosingIv;
    }
    public void setPreviousClosingIv(BigDecimal previousClosingIv) {
        this.previousClosingIv = previousClosingIv;
    }
    public BigDecimal getHighIv() {
        return highIv;
    }
    public void setHighIv(BigDecimal highIv) {
        this.highIv = highIv;
    }
    public BigDecimal getLowIv() {
        return lowIv;
    }
    public void setLowIv(BigDecimal lowIv) {
        this.lowIv = lowIv;
    }
}
