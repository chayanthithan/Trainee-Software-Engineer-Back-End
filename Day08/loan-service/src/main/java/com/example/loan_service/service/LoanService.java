package com.example.loan_service.service;

import com.example.loan_service.repository.LoanRepository;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
}
