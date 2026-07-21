package com.finverse.service;

import java.math.BigDecimal;

import com.finverse.entity.Transaction;

public interface TransactionService {

    Transaction addMoney();

    Transaction withdraw();

    Transaction transfer();

    Transaction currencyConversion();

    Transaction getTransactionHistory();

}