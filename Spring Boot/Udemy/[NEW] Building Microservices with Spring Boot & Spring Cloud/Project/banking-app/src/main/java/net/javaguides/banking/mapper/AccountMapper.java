package net.javaguides.banking.mapper;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;

public class AccountMapper {

  public static Account mapToAccount(AccountDto accountDto) {
    return new Account(
        accountDto.id(), accountDto.accountHolderName(), accountDto.balance());
  }

  public static AccountDto mapToAccountDto(Account account) {
    return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
  }
}
