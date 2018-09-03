package com.blueharvest.api.service.account.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueharvest.api.APIException;
import com.blueharvest.api.model.Account;
import com.blueharvest.api.model.AccountRequest;
import com.blueharvest.api.model.Customer;
import com.blueharvest.api.model.Transaction;
import com.blueharvest.api.model.Transaction.TransactionTypeEnum;
import com.blueharvest.api.repository.AccountRepository;
import com.blueharvest.api.service.account.AccountService;
import com.blueharvest.api.service.customer.CustomerService;
import com.blueharvest.api.service.transaction.TransactionService;
import com.blueharvest.api.util.ModelValidator;


/**
 * Account service for creating an existing Customer's account.
 * This service uses JPA respository for data access.
 * @author shanda
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	CustomerService customerService;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionService transactionService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@Override
	@Transactional
	/**
	 * Opens an account after due validation , if initial credit is passed 
	 * then a new transaction is also executed for the account.
	 */
	public Account createAccount(AccountRequest accountRequest) {

		ModelValidator.validate(accountRequest);

		Long customerID = accountRequest.getCustomerID();

		Customer customer = customerService.retrieveCustomer(customerID);

		if (customer == null) {
			throw new APIException("Invalid Customer ID specified ");
		}

		Account account = new Account();
		account.setCustomerID(customerID);
		Float initialCredit = accountRequest.getInitialCredit();
		account.setBalance(initialCredit);
		accountRepository.save(account);
		
		if (initialCredit != null && initialCredit > 0) {
			
			// make a transaction for the initial credit amount
			Transaction transaction = new Transaction();
			transaction.setAccountID(account.getAccountID());
			transaction.setCustomerID(customerID);
			transaction.setAmount(initialCredit);
			transaction.setTransactionType(TransactionTypeEnum.CREDIT);
			transaction.setTransactionDate(new Date());
			transactionService.submitTransaction(transaction);
			
		}

		


		return account;
	}

	/**
	 * fetch a specific account 
	 */
	public Account retrieveAccount(Long accountID) {

		Optional<Account> account = accountRepository.findById(accountID);
		if (!account.isPresent()) {
			throw new APIException("Account not found");
		}

		return account.get();

	}

	/**
	 * fetch all accounts
	 */
	public List<Account> retrieveAllAccounts() {

		List<Account> accounts = accountRepository.findAll();

		return accounts;

	}

}
