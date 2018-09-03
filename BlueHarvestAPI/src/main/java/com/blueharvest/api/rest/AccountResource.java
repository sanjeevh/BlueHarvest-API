package com.blueharvest.api.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blueharvest.api.model.Account;
import com.blueharvest.api.model.AccountRequest;
import com.blueharvest.api.service.account.AccountService;

@RestController
public class AccountResource {


	
	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	public List<Account> retrieveAllAccounts() {
		
		return accountService.retrieveAllAccounts();
	}

	@GetMapping("/accounts/{id}")
	public Account retrieveStudent(@PathVariable long id) {
		
		return accountService.retrieveAccount(id);
	}

	
	@PostMapping("/accounts")
	public ResponseEntity<Account> createAccount(@RequestBody @Valid AccountRequest accountRequest) {

		Account account = accountService.createAccount(accountRequest);
		
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
		

	}	
	

}
