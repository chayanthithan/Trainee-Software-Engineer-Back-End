package com.example.loan_service.api.convert;

import com.example.loan_service.dto.LoanDto;
import com.example.loan_service.entity.Loan;

import java.time.LocalDate;

public class LoanConverter {

    public Loan convertLoandtoToLoan(LoanDto loanDto){
        return Loan.builder()
                .userId(loanDto.getUserId())
                .loanType(loanDto.getLoanType())
                .loanAmount(loanDto.getLoanAmount())
                .interestRate(loanDto.getInterestRate())
                .monthlyInstallment(loanDto.getMonthlyInstallment())
                .repaymentStartDate(loanDto.getRepaymentStartDate())
                .approvalDate(loanDto.getApprovalDate())
                .build();
    }
}
