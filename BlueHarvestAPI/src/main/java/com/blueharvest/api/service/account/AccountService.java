package com.blueharvest.api.service.account;

import java.util.List;

import com.blueharvest.api.model.Account;
import com.blueharvest.api.model.AccountRequest;

public interface AccountService {

	public Account createAccount(AccountRequest accountRequest);
	
	public Account retrieveAccount(Long accountID);

	public List<Account> retrieveAllAccounts() ;
	
}
