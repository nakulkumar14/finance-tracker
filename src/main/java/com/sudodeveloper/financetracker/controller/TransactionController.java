package com.sudodeveloper.financetracker.controller;

import com.sudodeveloper.financetracker.dto.TransactionDTO;
import com.sudodeveloper.financetracker.model.CustomUserDetails;
import com.sudodeveloper.financetracker.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@Validated
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @GetMapping
  public ResponseEntity<List<TransactionDTO>> getTransactions(@AuthenticationPrincipal CustomUserDetails userDetails) {
    return ResponseEntity.ok(transactionService.getUserTransactions(userDetails.getUsername()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(transactionService.getTransactionById(id));
  }

  @PostMapping
  public ResponseEntity<TransactionDTO> addTransaction(@Valid @RequestBody TransactionDTO transactionDTO, @AuthenticationPrincipal CustomUserDetails userDetails) {
    return ResponseEntity.ok(transactionService.addTransaction(transactionDTO, userDetails.getUsername()));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removeTransactionById(@PathVariable("id") Long id) {
    transactionService.removeTransactionById(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable("id") Long id, @Valid @RequestBody TransactionDTO transactionDTO) {
    return ResponseEntity.ok(transactionService.updateTransaction(id, transactionDTO));
  }

}
