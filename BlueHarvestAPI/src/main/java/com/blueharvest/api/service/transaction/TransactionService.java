package com.blueharvest.api.service.transaction;

import com.blueharvest.api.model.Transaction;

public interface TransactionService {
	
	public Transaction submitTransaction(Transaction transaction);

}
