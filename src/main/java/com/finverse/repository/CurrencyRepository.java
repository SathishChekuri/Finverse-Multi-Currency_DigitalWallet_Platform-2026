package com.finverse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finverse.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findByCurrencyCode(String currencyCode);

}