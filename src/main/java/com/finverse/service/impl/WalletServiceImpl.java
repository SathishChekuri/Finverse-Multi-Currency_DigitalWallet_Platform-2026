package com.finverse.service.impl;

import org.springframework.stereotype.Service;

import com.finverse.entity.User;
import com.finverse.entity.Wallet;
import com.finverse.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

    @Override
    public Wallet createWallet(User user) {
        return null;
    }

    @Override
    public Wallet getWallet(Long userId) {
        return null;
    }

    @Override
    public Wallet freezeWallet(Long walletId) {
        return null;
    }

    @Override
    public Wallet closeWallet(Long walletId) {
        return null;
    }
}
