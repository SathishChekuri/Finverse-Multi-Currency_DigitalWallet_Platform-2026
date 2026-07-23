package com.finverse.service.impl;

import java.math.BigDecimal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.finverse.dto.LoginRequest;
import com.finverse.dto.LoginResponse;
import com.finverse.dto.UserRegistrationRequest;
import com.finverse.entity.Currency;
import com.finverse.entity.User;
import com.finverse.entity.Wallet;
import com.finverse.entity.WalletBalance;
import com.finverse.enums.AccountStatus;
import com.finverse.enums.Role;
import com.finverse.enums.WalletStatus;
import com.finverse.exception.DuplicateResourceException;
import com.finverse.exception.InvalidTransactionException;
import com.finverse.exception.ResourceNotFoundException;
import com.finverse.jwt.JwtService;
import com.finverse.repository.CurrencyRepository;
import com.finverse.repository.UserRepository;
import com.finverse.repository.WalletBalanceRepository;
import com.finverse.repository.WalletRepository;
import com.finverse.service.UserService;
import com.finverse.util.WalletNumberGenerator;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final CurrencyRepository currencyRepository;
    private final WalletBalanceRepository walletBalanceRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserServiceImpl(
            UserRepository userRepository,
            WalletRepository walletRepository,
            CurrencyRepository currencyRepository,
            WalletBalanceRepository walletBalanceRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.currencyRepository = currencyRepository;
        this.walletBalanceRepository = walletBalanceRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public User register(UserRegistrationRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        if (userRepository.existsByMobileNumber(request.getMobileNumber())) {
            throw new DuplicateResourceException("Mobile number already exists");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(encodedPassword)
                .mobileNumber(request.getMobileNumber())
                .role(Role.USER)
                .status(AccountStatus.ACTIVE)
                .build();

        user = userRepository.save(user);

        Wallet wallet = Wallet.builder()
                .walletNumber(WalletNumberGenerator.generate())
                .walletStatus(WalletStatus.ACTIVE)
                .dailyTransferLimit(new BigDecimal("50000"))
                .user(user)
                .build();

        wallet = walletRepository.save(wallet);

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

        return user;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
System.out.println("Login started");

User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() ->
                new ResourceNotFoundException("User not found"));

System.out.println("User found");

boolean match = passwordEncoder.matches(
        request.getPassword(),
        user.getPassword());

System.out.println("Password Match = " + match);

String token = jwtService.generateToken(user.getEmail());

System.out.println("Token Generated");

return LoginResponse.builder()
        .token(token)
        .tokenType("Bearer")
        .userId(user.getId())
        .fullName(user.getFullName())
        .email(user.getEmail())
        .build();
}
}