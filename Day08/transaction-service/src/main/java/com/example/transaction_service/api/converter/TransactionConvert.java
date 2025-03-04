package com.example.transaction_service.api.converter;

import com.example.transaction_service.dto.TransactionDto;
import com.example.transaction_service.entity.Transaction;

import java.time.LocalDate;

public class TransactionConvert {

    public Transaction convertTransactionDtoToTransaction(TransactionDto transactionDto){
        return Transaction.builder()
                .type(transactionDto.getType())
                .fromAccountId(transactionDto.getFromAccountId())
                .amount(transactionDto.getFromAccountId())
                .toAccountId(transactionDto.getToAccountId())
                .transactionType(transactionDto.getTransactionType())
                .transactionDate(transactionDto.getTransactionDate())
                .build();
    }
}
