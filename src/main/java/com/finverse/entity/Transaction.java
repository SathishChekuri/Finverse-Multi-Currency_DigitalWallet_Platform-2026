package com.finverse.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.finverse.enums.TransactionStatus;
import com.finverse.enums.TransactionType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false, unique = true)
private String transactionReference;
@Column(nullable = false, precision = 19, scale = 2)
private BigDecimal amount;
@ManyToOne
@JoinColumn(name = "sender_wallet_id")
private Wallet senderWallet;
@ManyToOne
@JoinColumn(name = "receiver_wallet_id")
private Wallet receiverWallet;
@ManyToOne
@JoinColumn(name = "currency_id", nullable = false)
private Currency currency;
@Enumerated(EnumType.STRING)
private TransactionType transactionType;
@Enumerated(EnumType.STRING)
private TransactionStatus transactionStatus;
@Column(length = 500)
private String description;
@CreationTimestamp
private LocalDateTime createdAt;
@UpdateTimestamp
private LocalDateTime updatedAt;
}