package com.sudodeveloper.financetracker.controller;

import com.sudodeveloper.financetracker.dto.DailySummary;
import com.sudodeveloper.financetracker.dto.MonthlySummary;
import com.sudodeveloper.financetracker.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SummaryController {

  @Autowired
  private SummaryService summaryService;

  @GetMapping("/users/{userId}/reports/monthly-summary")
  public ResponseEntity<MonthlySummary> getMonthlySummary(@PathVariable Long userId, @RequestParam int month, @RequestParam int year) {
    return ResponseEntity.ok(summaryService.getMonthlySummary(userId, month, year));
  }

  @GetMapping("/users/{userId}/reports/daily-summary")
  public ResponseEntity<DailySummary> getDailySummary(@PathVariable Long userId, @RequestParam Date date) {
    return ResponseEntity.ok(summaryService.getDailySummary(userId, date));
  }
}
