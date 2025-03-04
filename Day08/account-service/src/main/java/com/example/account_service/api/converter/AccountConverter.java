package com.example.account_service.api.converter;

import com.example.account_service.dto.AccountDto;
import com.example.account_service.entity.Account;

public class AccountConverter {

    public Account convertAccountDtoToAccount(AccountDto accountDto){
        return Account.builder()
                .userId(accountDto.getUserId())
                .accountType(accountDto.getAccountType())
                .balance(accountDto.getBalance())
                .accountNumber(accountDto.getAccountNumber())
                .build();
    }

}
