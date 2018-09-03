package com.blueharvest.api.service.customer;

import java.util.List;

import com.blueharvest.api.model.Customer;

public interface CustomerService {
	
	public Customer retrieveCustomer(long customerID);
	
	public List<Customer> retrieveAllCustomer();

}
