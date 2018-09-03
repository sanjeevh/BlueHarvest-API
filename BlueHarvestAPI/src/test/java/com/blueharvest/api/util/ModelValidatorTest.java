package com.blueharvest.api.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.blueharvest.api.APIException;
import com.blueharvest.api.model.Transaction;
import com.blueharvest.api.model.Transaction.TransactionTypeEnum;

public class ModelValidatorTest {
	
	 @Rule
	  public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testValidationFailure() {

		Transaction transaction = new Transaction();
		
		transaction.setAccountID(new Long(1));
		
		thrown.expect(APIException.class);
		
		ModelValidator.validate(transaction);

		
	}
	
	@Test
	public void testValidationPass() {

		Transaction transaction = new Transaction();
		
		transaction.setAccountID(new Long(1));
		transaction.setAmount(new Float(300));
		transaction.setCustomerID(new Long(1));
		transaction.setTransactionType(TransactionTypeEnum.CREDIT);
		
		ModelValidator.validate(transaction);

		
	}

}
