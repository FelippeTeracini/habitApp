package com.example.habitapp.service;

import com.example.habitapp.dao.AccountRepository;
import com.example.habitapp.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    public Account getAccountById(Integer accountId) throws Exception {
        Optional<Account> account = accountRepository.findById(accountId);
        if(account.isEmpty()){
            throw new Exception(String.format("Error getting account with id %d", accountId));
        }
        return account.get();
    }

    public Integer createAccount(Account account) {
        Account newAccount = accountRepository.save(account);
        return newAccount.getAccountId();
    }

}
