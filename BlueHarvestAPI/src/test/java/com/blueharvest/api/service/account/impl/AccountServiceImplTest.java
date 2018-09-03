package com.blueharvest.api.service.account.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.blueharvest.api.APIException;
import com.blueharvest.api.BlueHarvestPIApplication;
import com.blueharvest.api.model.Account;
import com.blueharvest.api.model.AccountRequest;
import com.blueharvest.api.model.Transaction;
import com.blueharvest.api.repository.AccountRepository;
import com.blueharvest.api.repository.TransactionRepository;
import com.blueharvest.api.service.account.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BlueHarvestPIApplication.class }, loader = AnnotationConfigContextLoader.class)
public class AccountServiceImplTest {

	@Autowired
	AccountService accountService; //Account service implementation bean ( Injected via Spring test support ) under test.

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	/**
	 * Test if the account creation works !
	 */
	public void testCreateAccountSuccess() {

		AccountRequest accountRequest = new AccountRequest();
		accountRequest.setCustomerID(new Long(1));
		accountRequest.setInitialCredit(new Float(500));
		Account account = accountService.createAccount(accountRequest);

		assertNotNull(account);

		assertNotNull(account.getAccountID());

		assertNotNull(accountRepository.findById(account.getAccountID()));

	}

	@Test
	/**
	 * test if the validation during account creation works
	 */
	public void testCreateAccountValidationFailure() {

		AccountRequest accountRequest = new AccountRequest();
		accountRequest.setCustomerID(new Long(999999999)); // non-existent customer
		accountRequest.setInitialCredit(new Float(500));

		thrown.expect(APIException.class);

		Account account = accountService.createAccount(accountRequest);

	}
	
	@Test
	/**
	 * Test if transaction is successfully created when initial credit is provided during Account creation.
	 */
	public void testCreateAccountTransaction() {

		AccountRequest accountRequest = new AccountRequest();
		accountRequest.setCustomerID(new Long(1));
		accountRequest.setInitialCredit(new Float(500));
		Account account = accountService.createAccount(accountRequest);

		assertNotNull(account);

		List<Transaction> transactions = transactionRepository.findByAccountID(account.getAccountID());

		assertNotNull(transactions);

	}	
	
	@Test
	/**
	 * Test to ensure that no transaction is created if the initial credit is not passed during account creation
	 */
	public void testCreateAccountNoTransaction() {

		AccountRequest accountRequest = new AccountRequest();
		accountRequest.setCustomerID(new Long(1));
		Account account = accountService.createAccount(accountRequest);

		assertNotNull(account);

		List<Transaction> transactions = transactionRepository.findByAccountID(account.getAccountID());

		assertEquals(0, transactions.size());

	}	

	@Test
	public void testRetrieveAccount() {

		Account account1 = new Account();
		account1.setCustomerID(new Long(1));
		account1.setBalance(new Float(1000));

		account1 = accountRepository.save(account1);

		Account account2 = accountService.retrieveAccount(account1.getAccountID());

		assertEquals(account1, account2);

	}

	@Test
	public void testRetrieveAllAccounts() {
		
		Account account1 = new Account();
		account1.setCustomerID(new Long(1));
		account1.setBalance(new Float(1000));
		
		Account account2 = new Account();
		account2.setCustomerID(new Long(1));
		account2.setBalance(new Float(1000));
		
		accountRepository.save(account1);
		accountRepository.save(account2);
		
		List<Account> accounts = accountService.retrieveAllAccounts();
		
		assertNotNull(accounts);
		
		assertEquals(2, accounts.size());
		
	}

}
