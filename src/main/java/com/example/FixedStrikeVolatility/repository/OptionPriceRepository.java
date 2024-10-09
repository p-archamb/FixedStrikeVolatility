package com.example.FixedStrikeVolatility.repository;

import com.example.FixedStrikeVolatility.model.OptionPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OptionPriceRepository extends JpaRepository<OptionPrice, Long> {
    Optional<OptionPrice> findFirstByInstrumentIdOrderByTimestampDesc(Long instrumentId);
    List<OptionPrice> findByInstrumentIdAndTimestampBetween(Long instrumentId, LocalDateTime start, LocalDateTime end);
}
