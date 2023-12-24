package com.simplebanking.accountservice.controller;

import com.simplebanking.accountservice.dto.AccountDto;
import com.simplebanking.accountservice.dto.AddAccountRequest;
import com.simplebanking.accountservice.dto.CreateAccountTransactionRequest;
import com.simplebanking.accountservice.dto.GetAccountResponse;
import com.simplebanking.accountservice.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(){
        return ResponseEntity.ok(accountService.createAccount());
    }

    @PutMapping
    public ResponseEntity<Void> defineAccountToCustomer(@RequestBody AddAccountRequest request){
        accountService.defineAccountToCustomer(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountNo}")
    public ResponseEntity<GetAccountResponse> getAccount(@PathVariable String accountNo){
        return ResponseEntity.ok(accountService.getAccountByAccountNo(accountNo));
    }

    @PutMapping("/transaction")
    public ResponseEntity<Void> transaction(@RequestBody CreateAccountTransactionRequest request){
        accountService.createTransaction(request);
        return ResponseEntity.ok().build();
    }

}
