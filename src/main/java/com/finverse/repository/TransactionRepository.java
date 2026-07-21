package com.finverse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finverse.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByTransactionReference(String transactionReference);

}