package com.sudodeveloper.financetracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Date;
import java.util.StringJoiner;

public class TransactionDTO {
  private Long id;

  @NotNull(message = "Date cannot be null")
  private Date date;

  @Positive(message = "Cannot be negative")
  private Double amount;

  @NotBlank(message = "type cannot be blank")
  private String type;  // income or expense

  @NotBlank(message = "category cannot be blank")
  private String category;

  private String note;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", TransactionDTO.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("date=" + date)
        .add("amount=" + amount)
        .add("type='" + type + "'")
        .add("category='" + category + "'")
        .add("note='" + note + "'")
        .toString();
  }
}
