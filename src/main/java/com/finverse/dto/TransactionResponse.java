package com.finverse.dto;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {

    private String transactionReference;

    private BigDecimal amount;

    private String transactionStatus;

    private String transactionType;
}