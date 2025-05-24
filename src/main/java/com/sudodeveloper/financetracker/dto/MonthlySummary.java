package com.sudodeveloper.financetracker.dto;

import java.util.Map;

public class MonthlySummary {
  private int month;
  private int year;
  private double totalIncome;
  private double totalExpenses;
  private double netSavings;
  private Map<String, Double> categoryWiseIncome;
  private Map<String, Double> categoryWiseExpenses;

  public MonthlySummary(int month, int year, double totalIncome, double totalExpenses, double netSavings,
                        Map<String, Double> categoryWiseIncome, Map<String, Double> categoryWiseExpenses) {
    this.month = month;
    this.year = year;
    this.totalIncome = totalIncome;
    this.totalExpenses = totalExpenses;
    this.netSavings = netSavings;
    this.categoryWiseIncome = categoryWiseIncome;
    this.categoryWiseExpenses = categoryWiseExpenses;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
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
