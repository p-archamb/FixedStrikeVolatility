package com.example.FixedStrikeVolatility.repository;

import com.example.FixedStrikeVolatility.model.DailySummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DailySummaryRepository extends JpaRepository<DailySummary, Long> {
    Optional<DailySummary> findByInstrumentIdAndDate(Long instrumentId, LocalDate date);
    List<DailySummary> findByDate(LocalDate date);
}
