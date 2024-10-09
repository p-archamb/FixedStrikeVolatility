package com.example.FixedStrikeVolatility.repository;

import com.example.FixedStrikeVolatility.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    List<Instrument> findByInstrumentTypeAndLastUpdatedAfter(String instrumentType, LocalDateTime timestamp);
}
