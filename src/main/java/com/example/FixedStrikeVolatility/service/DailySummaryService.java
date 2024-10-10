package com.example.FixedStrikeVolatility.service;

import com.example.FixedStrikeVolatility.model.DailySummary;
import com.example.FixedStrikeVolatility.model.Instrument;
import com.example.FixedStrikeVolatility.model.OptionAnalytics;
import com.example.FixedStrikeVolatility.model.OptionPrice;
import com.example.FixedStrikeVolatility.repository.DailySummaryRepository;
import com.example.FixedStrikeVolatility.repository.InstrumentRepository;
import com.example.FixedStrikeVolatility.repository.OptionAnalyticsRepository;
import com.example.FixedStrikeVolatility.repository.OptionPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service class that manages the daily summary object for all option instruments. This class
 * creates, updates, and retrieves DailySummary Objects. The service class acts as an intermediary
 * between the controller and the repositories.
 */
@Service
public class DailySummaryService {
    private final InstrumentRepository instrumentRepository;
    private final OptionPriceRepository optionPriceRepository;
    private final OptionAnalyticsRepository optionAnalyticsRepository;
    private final DailySummaryRepository dailySummaryRepository;

    /**
     * Constructor. Autowired is automatic dependency injection by SpringBoot.
     * @param instrumentRepository
     * @param optionPriceRepository
     * @param optionAnalyticsRepository
     * @param dailySummaryRepository
     */
    @Autowired
    public DailySummaryService(InstrumentRepository instrumentRepository, OptionPriceRepository optionPriceRepository, OptionAnalyticsRepository optionAnalyticsRepository, DailySummaryRepository dailySummaryRepository) {
        this.instrumentRepository = instrumentRepository;
        this.optionPriceRepository = optionPriceRepository;
        this.optionAnalyticsRepository = optionAnalyticsRepository;
        this.dailySummaryRepository = dailySummaryRepository;
    }

    /**
     * Updates the daily summary for all options that have been updated today.This method is
     * called by the scheduler
     */
    public void updateDailySummaries() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();

        List<Instrument> todayOptions = instrumentRepository.findByInstrumentTypeAndLastUpdatedAfter("OPTION", startOfDay);
        for (Instrument instrument : todayOptions) {
            try {
                updateDailySummary(instrument.getId(), today);
            } catch (Exception e) {
                System.out.println("Error updating daily summaries for instrument: " + instrument.getId() +"error: " + e.getMessage());
            }
        }
    }

    /**
     * Helper Function to get all data needed for a single DailySummary Object, update the object, and then save the data in the
     * daily summary table in postgres. If not daily summary object exists for the option, it will create one.
     * @param instrumentId
     * @param date
     */
    private void updateDailySummary(Long instrumentId, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.plusDays(1).atStartOfDay();

        Instrument instrument = instrumentRepository.findById(instrumentId).orElseThrow(() -> new RuntimeException("Instrument not found: " + instrumentId));
        OptionPrice latestPrice = optionPriceRepository.findFirstByInstrumentIdOrderByTimestampDesc(instrumentId).orElseThrow(() -> new RuntimeException("No option price found for instrument: " + instrumentId));
        OptionAnalytics latestAnalytics = optionAnalyticsRepository.findFirstByInstrumentIdOrderByTimestampDesc(instrumentId).orElseThrow(() -> new RuntimeException("No option analytics found for instrument: " + instrumentId));
        DailySummary dailySummary = dailySummaryRepository.findByInstrumentIdAndDate(instrumentId, date).orElse(new DailySummary(instrumentId, date));
        List<OptionPrice> todayOptionPrices = optionPriceRepository.findByInstrumentIdAndTimestampBetween(instrumentId, startOfDay, endOfDay);
        List<OptionAnalytics> todayOptionAnalytics = optionAnalyticsRepository.findByInstrumentIdAndTimestampBetween(instrumentId, startOfDay, endOfDay);

        dailySummary.setExpirationDate(instrument.getExpirationDate());
        updateDailySummary(dailySummary, todayOptionPrices, todayOptionAnalytics, latestPrice, latestAnalytics);
        dailySummaryRepository.save(dailySummary);
    }

    /**
     * Updates a daily summary object with all the latest data needed in a daily summary object. It sets
     * the opening price to the first datapoint retrieved today and the closing price as the latest data point.
     * @param dailySummary
     * @param optionPrices
     * @param optionAnalytics
     * @param latestPrice
     * @param latestAnalytics
     */
    private void updateDailySummary(DailySummary dailySummary, List<OptionPrice> optionPrices, List<OptionAnalytics> optionAnalytics, OptionPrice latestPrice, OptionAnalytics latestAnalytics) {
        dailySummary.setClosingPrice(latestPrice.getPrice());
        dailySummary.setClosingIV(latestAnalytics.getImpliedVolatility());

        //Opening price should be first price retrieved today
        if (dailySummary.getOpeningPrice() == null) {
            dailySummary.setOpeningPrice(optionPrices.get(0).getPrice());
            dailySummary.setOpeningIV(optionAnalytics.get(0).getImpliedVolatility());
        }
        //add logic to set high and low, but don't need right now
    }

    /**
     * This function returns a list of all daily summaries for a specific date.
     * @param date
     * @return
     */
    public List<DailySummary> getDailySummaries(LocalDate date) {
        return dailySummaryRepository.findByDate(date);
    }
}
