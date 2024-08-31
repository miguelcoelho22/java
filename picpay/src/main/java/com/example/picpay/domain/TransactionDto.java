package com.example.picpay.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDto(BigDecimal amount, Long senderId, Long receiverId) {
}
