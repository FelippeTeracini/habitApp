package com.example.habitapp.controller;

import com.example.habitapp.model.Account;
import com.example.habitapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @GetMapping("{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer accountId){
        try{
            Account account = accountService.getAccountById(accountId);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<Integer> createAccount(@RequestBody Account account){
        try {
            Integer accountId = accountService.createAccount(account);
            return new ResponseEntity<>(accountId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
