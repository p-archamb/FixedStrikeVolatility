package com.example.FixedStrikeVolatility.repository;

import com.example.FixedStrikeVolatility.model.OptionPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * This interface is a repository for OptionPrice entities. Extends JPARepository which provides
 * CRUD operations and pagination. Spring will automatically implement this interface at runtime.
 */
public interface OptionPriceRepository extends JpaRepository<OptionPrice, Long> {
    Optional<OptionPrice> findFirstByInstrumentIdOrderByTimestampDesc(Long instrumentId);
    List<OptionPrice> findByInstrumentIdAndTimestampBetween(Long instrumentId, LocalDateTime start, LocalDateTime end);
}
