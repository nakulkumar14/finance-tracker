package com.sudodeveloper.financetracker.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.StringJoiner;

@Entity
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date date;
  private Double amount;
  private String type;  // income or expense
  private String category;
  private String note;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Transaction.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("date=" + date)
        .add("amount=" + amount)
        .add("type='" + type + "'")
        .add("category='" + category + "'")
        .add("note='" + note + "'")
        .add("user=" + user)
        .toString();
  }
}
