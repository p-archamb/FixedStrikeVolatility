package com.example.FixedStrikeVolatility.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "daily_summary")
public class DailySummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long instrumentId;
    private LocalDate date;
    private BigDecimal openingPrice;
    private BigDecimal closingPrice;
    private BigDecimal previousClosingPrice;
    private BigDecimal highPrice;
    private BigDecimal lowPrice;
    private BigDecimal openingIV;
    private BigDecimal closingIV;
    private BigDecimal previousClosingIv;
    private BigDecimal highIv;
    private BigDecimal lowIv;

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
