package com.finverse.dto;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletResponse {

    private String walletNumber;

    private String walletStatus;

    private BigDecimal dailyTransferLimit;

}