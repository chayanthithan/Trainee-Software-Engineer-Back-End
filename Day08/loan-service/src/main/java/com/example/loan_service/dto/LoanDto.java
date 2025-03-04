package com.example.loan_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    private Long userId;
    private String loanType;
    private Double loanAmount;
    private Double interestRate;
    private int tenureMonths;
    private Double monthlyInstallment;
    private LocalDate approvalDate;
    private LocalDate repaymentStartDate;
}
