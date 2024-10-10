package com.example.FixedStrikeVolatility.scheduler;

import com.example.FixedStrikeVolatility.service.DailySummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * This scheduler will update the daily summaries at a fixed rate. Does this by calling the
 * Service to update the daily summaries every minute.
 * @Component annotates that this class is a Spring component to be automatically detected for dependency injection
 */
@Component
@EnableScheduling
public class DailySummaryScheduler {
    private final DailySummaryService dailySummaryService;

    @Autowired
    public DailySummaryScheduler(DailySummaryService dailySummaryService) {
        this.dailySummaryService = dailySummaryService;
    }

    @Scheduled(fixedRate = 60000) //1 minute
    public void scheduleDailySummary() {
        dailySummaryService.updateDailySummaries();
    }
}
