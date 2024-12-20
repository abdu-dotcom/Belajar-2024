package net.javaguides.banking.service.impl;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.mapper.AccountMapper;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

  @Override
  public AccountDto getAccountById(Long id) {
    Account account =
        accountRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Account does not exists"));

    return AccountMapper.mapToAccountDto(account);
  }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =
                accountRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Account does not exists"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    public AccountDto withdraw(Long id, double amount){
        // check account exists
        Account account =
                accountRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Account does not exists"));

        double balance = account.getBalance();

        // check balance
        if (balance  < amount){
            throw new RuntimeException("Insufficient amount");
        }

        double total = balance - amount;

        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
