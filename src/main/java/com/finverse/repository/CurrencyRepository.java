package com.finverse.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.finverse.entity.User;
import com.finverse.entity.Currency;
public interface CurrencyRepository extends JpaRepository<User, Long> {
Optional<Currency> findByCurrencyCode(Currency currencyCode);
}
