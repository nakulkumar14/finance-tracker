package com.sudodeveloper.financetracker.service;

import com.sudodeveloper.financetracker.dto.TransactionDTO;
import com.sudodeveloper.financetracker.entity.Transaction;
import com.sudodeveloper.financetracker.exceptions.FinanceTrackerException;
import com.sudodeveloper.financetracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  public List<TransactionDTO> getUserTransactions() {
    List<Transaction> transactions = transactionRepository.findByUserId(1l);
    List<TransactionDTO> transactionDTOS = new ArrayList<>();
    for (Transaction transaction : transactions) {
      transactionDTOS.add(getTransactionDTO(transaction));
    }

    return transactionDTOS;
  }

  public TransactionDTO getTransactionById(Long id) {
    Optional<Transaction> transactionOptional = transactionRepository.findById(id);
    if (transactionOptional.isPresent()) {
      Transaction transaction = transactionOptional.get();
      return getTransactionDTO(transaction);
    }
    throw new FinanceTrackerException("Transaction not found");
  }

  private TransactionDTO getTransactionDTO(Transaction transaction) {
    TransactionDTO transactionDTO = new TransactionDTO();
    transactionDTO.setAmount(transaction.getAmount());
    transactionDTO.setCategory(transaction.getCategory());
    transactionDTO.setDate(transaction.getDate());
    transactionDTO.setId(transaction.getId());
    transactionDTO.setNote(transaction.getNote());
    transactionDTO.setType(transaction.getType());
    return transactionDTO;
  }

  public void removeTransactionById(Long id) {
    transactionRepository.deleteById(id);
  }

  public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
    Transaction transaction = getTransaction(transactionDTO);
    Transaction saved = transactionRepository.save(transaction);
    return getTransactionDTO(saved);
  }

  private Transaction getTransaction(TransactionDTO transactionDTO) {
    Transaction transaction = new Transaction();
    transaction.setAmount(transactionDTO.getAmount());
    transaction.setCategory(transactionDTO.getCategory());
    transaction.setDate(transactionDTO.getDate());
    transaction.setNote(transactionDTO.getNote());
    transaction.setType(transactionDTO.getType());
    return transaction;
  }

  public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO) {
    Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
    if (optionalTransaction.isPresent()) {
      Transaction transaction = optionalTransaction.get();
      if (transactionDTO.getAmount() != null && !Objects.equals(transaction.getAmount(), transactionDTO.getAmount())) {
        transaction.setAmount(transactionDTO.getAmount());
      }
      if (StringUtils.hasText(transactionDTO.getCategory()) && !transactionDTO.getCategory().equals(transaction.getCategory())) {
        transaction.setCategory(transactionDTO.getCategory());
      }
      if (transactionDTO.getDate() != null && transactionDTO.getDate() != transaction.getDate()) {
        transaction.setDate(transactionDTO.getDate());
      }
      if (StringUtils.hasText(transactionDTO.getType()) && !transactionDTO.getType().equals(transaction.getType())) {
        transaction.setType(transactionDTO.getType());
      }
      if (StringUtils.hasText(transactionDTO.getNote()) && !transactionDTO.getNote().equals(transaction.getNote())) {
        transaction.setNote(transactionDTO.getNote());
      }
      Transaction updated = transactionRepository.save(transaction);
      return getTransactionDTO(updated);
    }
    throw new FinanceTrackerException("Transaction not found");
  }
}
