package com.finverse.service;

import com.finverse.entity.User;
import com.finverse.entity.Wallet;

public interface WalletService {

    Wallet createWallet(User user);

    Wallet getWallet(Long userId);

    Wallet freezeWallet(Long walletId);

    Wallet closeWallet(Long walletId);

}