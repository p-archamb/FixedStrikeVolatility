package com.example.FixedStrikeVolatility.repository;

import com.example.FixedStrikeVolatility.model.OptionAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * This interface is a repository for OptionAnalytic entities. Extends JPARepository which provides
 * CRUD operations and pagination. Spring will automatically implement this interface at runtime.
 */
public interface OptionAnalyticsRepository extends JpaRepository<OptionAnalytics, Long> {
    Optional<OptionAnalytics> findFirstByInstrumentIdOrderByTimestampDesc(Long instrumentId);
    List<OptionAnalytics> findByInstrumentIdAndTimestampBetween(Long instrumentId, LocalDateTime start, LocalDateTime end);
}
