package com.finverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finverse.entity.BankAccount;
import com.finverse.entity.User;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    List<BankAccount> findByUser(User user);

    List<BankAccount> findByPrimaryAccount(Boolean primaryAccount);

}