package com.sudodeveloper.financetracker.dto;

import java.util.Date;
import java.util.Map;

public class DailySummary {
  private Date date;
  private double totalIncome;
  private double totalExpenses;
  private double netSavings;
  private Map<String, Double> categoryWiseIncome;
  private Map<String, Double> categoryWiseExpenses;

  public DailySummary(Date date, double totalIncome, double totalExpenses, double netSavings, Map<String, Double> categoryWiseIncome, Map<String, Double> categoryWiseExpenses) {
    this.date = date;
    this.totalIncome = totalIncome;
    this.totalExpenses = totalExpenses;
    this.netSavings = netSavings;
    this.categoryWiseIncome = categoryWiseIncome;
    this.categoryWiseExpenses = categoryWiseExpenses;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getTotalIncome() {
    return totalIncome;
  }

  public void setTotalIncome(double totalIncome) {
    this.totalIncome = totalIncome;
  }

  public double getTotalExpenses() {
    return totalExpenses;
  }

  public void setTotalExpenses(double totalExpenses) {
    this.totalExpenses = totalExpenses;
  }

  public double getNetSavings() {
    return netSavings;
  }

  public void setNetSavings(double netSavings) {
    this.netSavings = netSavings;
  }

  public Map<String, Double> getCategoryWiseIncome() {
    return categoryWiseIncome;
  }

  public void setCategoryWiseIncome(Map<String, Double> categoryWiseIncome) {
    this.categoryWiseIncome = categoryWiseIncome;
  }

  public Map<String, Double> getCategoryWiseExpenses() {
    return categoryWiseExpenses;
  }

  public void setCategoryWiseExpenses(Map<String, Double> categoryWiseExpenses) {
    this.categoryWiseExpenses = categoryWiseExpenses;
  }
}
