package com.example.transaction_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private String type;
    private double amount;
    private Long fromAccountId; //(UUID, Foreign Key → Account)
    private Long toAccountId; //(UUID, Foreign Key → Account)
    private String transactionType; //(Enum: Deposit, Withdrawal, Transfer, Bill Payment)
    private LocalDate transactionDate;
}
