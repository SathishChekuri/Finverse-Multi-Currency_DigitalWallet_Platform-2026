package com.finverse.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.finverse.enums.CurrencyStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "currencies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false, unique = true, length = 3)
private String currencyCode;
@Column(nullable = false, length = 5)
private String currencySymbol;
@Column(nullable = false, precision = 19, scale = 4)
private BigDecimal exchangeRate;
@Enumerated(EnumType.STRING)
private CurrencyStatus status;
@CreationTimestamp
private LocalDateTime createdAt;
@UpdateTimestamp
private LocalDateTime updatedAt;
}
