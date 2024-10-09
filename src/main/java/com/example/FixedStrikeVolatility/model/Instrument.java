package com.example.FixedStrikeVolatility.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "instruments")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String instrumentType;
    private LocalDateTime lastUpdated;

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
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
