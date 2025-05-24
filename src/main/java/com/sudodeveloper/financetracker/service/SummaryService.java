package com.sudodeveloper.financetracker.service;

import com.sudodeveloper.financetracker.dto.DailySummary;
import com.sudodeveloper.financetracker.dto.MonthlySummary;
import com.sudodeveloper.financetracker.entity.Transaction;
import com.sudodeveloper.financetracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class SummaryService {

  @Autowired
  private TransactionRepository transactionRepository;

  public MonthlySummary getMonthlySummary(Long userId, int month, int year) {

    LocalDate startDate = LocalDate.of(year, month, 1);
    Date from = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

    LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
    Date to = Date.from(endDate.atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant());

    // Fetch transactions for the specified user and month
    List<Transaction> transactions = transactionRepository.findByUserIdAndDateBetween(userId, from, to);

    // Initialize summary variables
    double totalIncome = 0.0;
    double totalExpenses = 0.0;
    Map<String, Double> categoryWiseIncome = new HashMap<>();
    Map<String, Double> categoryWiseExpenses = new HashMap<>();

    // Process each transaction
    for (Transaction txn : transactions) {
      if (Objects.equals(txn.getType(), "income")) {
        totalIncome = totalIncome + txn.getAmount();
        categoryWiseIncome.put(txn.getCategory(), categoryWiseIncome.getOrDefault(txn.getCategory(), 0.0) + txn.getAmount());
      } else if (Objects.equals(txn.getType(), "expense")) {
        totalExpenses = totalExpenses + txn.getAmount();
        categoryWiseExpenses.put(txn.getCategory(), categoryWiseExpenses.getOrDefault(txn.getCategory(), 0.0) + txn.getAmount());
      }
    }

    // Calculate net savings
    double netSavings = totalIncome - totalExpenses;

    // Return the summary
    return new MonthlySummary(month, year, totalIncome, totalExpenses, netSavings, categoryWiseIncome, categoryWiseExpenses);
  }


  public DailySummary getDailySummary(Long userId, Date date) {
    List<Transaction> transactions = transactionRepository.findByUserIdAndDate(userId, date);
    // Initialize summary variables
    double totalIncome = 0.0;
    double totalExpenses = 0.0;
    Map<String, Double> categoryWiseIncome = new HashMap<>();
    Map<String, Double> categoryWiseExpenses = new HashMap<>();

    // Process each transaction
    for (Transaction txn : transactions) {
      if (Objects.equals(txn.getType(), "income")) {
        totalIncome = totalIncome + txn.getAmount();
        categoryWiseIncome.put(txn.getCategory(), categoryWiseIncome.getOrDefault(txn.getCategory(), 0.0) + txn.getAmount());
      } else if (Objects.equals(txn.getType(), "expense")) {
        totalExpenses = totalExpenses + txn.getAmount();
        categoryWiseExpenses.put(txn.getCategory(), categoryWiseExpenses.getOrDefault(txn.getCategory(), 0.0) + txn.getAmount());
      }
    }

    // Calculate net savings
    double netSavings = totalIncome - totalExpenses;
    return new DailySummary(date, totalIncome, totalExpenses, netSavings, categoryWiseIncome, categoryWiseExpenses);
  }
}
