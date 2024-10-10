package com.example.FixedStrikeVolatility.repository;

import com.example.FixedStrikeVolatility.model.DailySummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * This interface is a repository for daily summary entities. Extends JPARepository which provides
 * CRUD operations and pagination. Spring will automatically implement this interface at runtime.
 */
public interface DailySummaryRepository extends JpaRepository<DailySummary, Long> {
    Optional<DailySummary> findByInstrumentIdAndDate(Long instrumentId, LocalDate date);
    List<DailySummary> findByDate(LocalDate date);
}
