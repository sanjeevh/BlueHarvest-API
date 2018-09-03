package com.blueharvest.api.service.transaction.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueharvest.api.model.Transaction;
import com.blueharvest.api.repository.TransactionRepository;
import com.blueharvest.api.service.transaction.TransactionService;
import com.blueharvest.api.util.ModelValidator;

/**
 * Transaction service for submitting a debit/credit transaction on an account
 * This service uses JPA respository for data access.
 * @author shanda
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction submitTransaction(Transaction transaction) {

		ModelValidator.validate(transaction);
		
		transactionRepository.save(transaction);
		
		return transaction;
				
	}

	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}

	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

}
