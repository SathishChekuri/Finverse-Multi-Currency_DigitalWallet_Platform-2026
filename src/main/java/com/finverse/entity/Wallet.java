package com.finverse.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.finverse.enums.WalletStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false, unique = true)
private String walletNumber;
@Enumerated(EnumType.STRING)
private WalletStatus walletStatus;
@Column(nullable = false, precision = 19, scale = 2)
private BigDecimal dailyTransferLimit;
@OneToOne
@JoinColumn(name = "user_id", nullable = false, unique = true)
private Users user;
@CreationTimestamp
private LocalDateTime createdAt;

@UpdateTimestamp
private LocalDateTime updatedAt;
@OneToMany(
        mappedBy = "wallet",
        cascade = CascadeType.ALL,
        orphanRemoval = true
)
private List<WalletBalance> walletBalances;
}
