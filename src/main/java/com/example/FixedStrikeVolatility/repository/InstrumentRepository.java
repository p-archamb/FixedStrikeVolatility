package com.example.FixedStrikeVolatility.repository;

import com.example.FixedStrikeVolatility.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This interface is a repository for Instrument entities. Extends JPARepository which provides
 * CRUD operations and pagination. Spring will automatically implement this interface at runtime.
 */
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    List<Instrument> findByInstrumentTypeAndLastUpdatedAfter(String instrumentType, LocalDateTime timestamp);
}
