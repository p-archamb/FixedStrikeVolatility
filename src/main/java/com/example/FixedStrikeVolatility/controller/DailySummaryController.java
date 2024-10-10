package com.example.FixedStrikeVolatility.controller;

import com.example.FixedStrikeVolatility.model.DailySummary;
import com.example.FixedStrikeVolatility.service.DailySummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Rest Controller Class to handle http requests related to daily summaries.
 * This class handles web requests and returns data directly in the response body.
 * Will use the dailySummaryService to fetch data.
 * @RestController combines @Controller and @ResponseBody
 */
@RestController
@RequestMapping("/daily-summary")
public class DailySummaryController {
    private final DailySummaryService dailySummaryService;

    @Autowired
    public DailySummaryController(DailySummaryService dailySummaryService) {
        this.dailySummaryService = dailySummaryService;
    }

    /**
     * This function handles any get requests to the request mapping endpoint.
     * @param date(optional)
     * @return ResponseEntity containing a list of DailySummary Objects
     */
    @GetMapping
    public ResponseEntity<List<DailySummary>> getDailySummaries(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        if(date == null){
            date = LocalDate.now();
        }
        List<DailySummary> dailySummaries = dailySummaryService.getDailySummaries(date);
        return ResponseEntity.ok(dailySummaries);

    }
}
