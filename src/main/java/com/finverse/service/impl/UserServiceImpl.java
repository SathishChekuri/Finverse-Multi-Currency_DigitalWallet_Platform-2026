package com.finverse.service.impl;

import java.math.BigDecimal;
import com.finverse.entity.Currency;
import com.finverse.entity.WalletBalance;
import com.finverse.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.finverse.dto.LoginRequest;
import com.finverse.dto.UserRegistrationRequest;
import com.finverse.entity.User;
import com.finverse.entity.Wallet;
import com.finverse.enums.AccountStatus;
import com.finverse.exception.DuplicateResourceException;
import com.finverse.repository.CurrencyRepository;
import com.finverse.repository.UserRepository;
import com.finverse.repository.WalletBalanceRepository;
import com.finverse.repository.WalletRepository;
import com.finverse.service.UserService;
import com.finverse.util.WalletNumberGenerator;
import com.finverse.enums.Role;
import com.finverse.enums.WalletStatus;
@Service
public class UserServiceImpl implements UserService{
    public UserServiceImpl(UserRepository userRepository,
                       WalletRepository walletRepository,
                       CurrencyRepository currencyRepository,
                       WalletBalanceRepository walletBalanceRepository,
                       PasswordEncoder passwordEncoder) {

    this.userRepository = userRepository;
    this.walletRepository = walletRepository;
    this.currencyRepository = currencyRepository;
    this.walletBalanceRepository = walletBalanceRepository;
    this.passwordEncoder = passwordEncoder;
    }
     private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final CurrencyRepository currencyRepository;
    private final WalletBalanceRepository walletBalanceRepository;
   private final PasswordEncoder passwordEncoder;
       @Override
    public User register(UserRegistrationRequest request) {

    // Check duplicate email
    if (userRepository.existsByEmail(request.getEmail())) {
        throw new DuplicateResourceException("Email already exists");
    }

    // Check duplicate mobile
    if (userRepository.existsByMobileNumber(request.getMobileNumber())) {
        throw new DuplicateResourceException("Mobile number already exists");
    }

    // Encrypt password
    String encodedPassword = passwordEncoder.encode(request.getPassword());

    // Create User
    User user = User.builder()
            .fullName(request.getFullName())
            .email(request.getEmail())
            .password(encodedPassword)
            .mobileNumber(request.getMobileNumber())
            .role(Role.USER)
            .status(AccountStatus.ACTIVE)
            .build();

    // Save User
    user = userRepository.save(user);
    // Create Wallet
      Wallet wallet = Wallet.builder()
        .walletNumber(WalletNumberGenerator.generate())
        .walletStatus(WalletStatus.ACTIVE)
        .dailyTransferLimit(new BigDecimal("50000"))
        .user(user)
        .build();
        wallet = walletRepository.save(wallet);
    // Create INR Balance
       Currency currency = currencyRepository
        .findByCurrencyCode("INR")
        .orElseThrow(() ->
            new ResourceNotFoundException("Currency not found"));
        WalletBalance walletBalance = WalletBalance.builder()
        .wallet(wallet)
        .currency(currency)
        .balance(BigDecimal.ZERO)
        .build();
        walletBalanceRepository.save(walletBalance);
    // Return User
        return user;

    }

    @Override
    public User login(LoginRequest request) {
        // Find User
        // Verify Password
        // Generate JWT
        // Return User
        return null;
    }
}
