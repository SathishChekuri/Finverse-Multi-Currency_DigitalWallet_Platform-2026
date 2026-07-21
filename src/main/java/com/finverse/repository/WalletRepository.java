package com.finverse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finverse.entity.User;
import com.finverse.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByWalletNumber(String walletNumber);

    Optional<Wallet> findByUser(User user);

}