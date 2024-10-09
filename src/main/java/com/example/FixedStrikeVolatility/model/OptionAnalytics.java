package com.example.FixedStrikeVolatility.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "option_analytics")
public class OptionAnalytics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long instrumentId;
    private BigDecimal impliedVolatility;
    private BigDecimal delta;
    private BigDecimal gamma;
    private BigDecimal vega;
    private BigDecimal theta;
    private int days_to_expiration;
    private LocalDateTime timestamp;

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
    public BigDecimal getImpliedVolatility() {
        return impliedVolatility;
    }
    public void setImpliedVolatility(BigDecimal impliedVolatility) {
        this.impliedVolatility = impliedVolatility;
    }
    public BigDecimal getDelta() {
        return delta;
    }
    public void setDelta(BigDecimal delta) {
        this.delta = delta;
    }
    public BigDecimal getGamma() {
        return gamma;
    }
    public void setGamma(BigDecimal gamma) {
        this.gamma = gamma;
    }
    public BigDecimal getVega() {
        return vega;
    }
    public void setVega(BigDecimal vega) {
        this.vega = vega;
    }
    public BigDecimal getTheta() {
        return theta;
    }
    public void setTheta(BigDecimal theta) {
        this.theta = theta;
    }
    public int getDays_to_expiration() {
        return days_to_expiration;
    }
    public void setDays_to_expiration(int days_to_expiration) {
        this.days_to_expiration = days_to_expiration;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
