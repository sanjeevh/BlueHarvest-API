package com.blueharvest.api.service.customer.impl;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.blueharvest.api.BlueHarvestPIApplication;
import com.blueharvest.api.model.Account;
import com.blueharvest.api.model.AccountRequest;
import com.blueharvest.api.model.Customer;
import com.blueharvest.api.repository.CustomerRepository;
import com.blueharvest.api.service.account.AccountService;
import com.blueharvest.api.service.customer.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BlueHarvestPIApplication.class }, loader = AnnotationConfigContextLoader.class)
public class CustomerServiceImplTest {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void testRetrieveCustomer() {
		
		Customer customer2 = customerService.retrieveCustomer(new Long(1));
		
		assertNotNull(customer2);
	}
	

}
