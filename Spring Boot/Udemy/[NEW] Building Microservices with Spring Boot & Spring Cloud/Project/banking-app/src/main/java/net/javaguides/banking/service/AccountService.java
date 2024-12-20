package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);
}
