package com.finverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finverse.entity.WalletBalance;

public interface WalletBalanceRepository extends JpaRepository<WalletBalance, Long> {

}