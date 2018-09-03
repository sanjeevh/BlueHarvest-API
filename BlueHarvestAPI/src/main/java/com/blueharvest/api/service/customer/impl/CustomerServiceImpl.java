package com.blueharvest.api.service.customer.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueharvest.api.model.Customer;
import com.blueharvest.api.repository.CustomerRepository;
import com.blueharvest.api.service.customer.CustomerService;

/**
 * Customer ( Bank user ) service for retrieving existing customer's information.
 * This service uses JPA respository for data access.
 * @author shanda
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer retrieveCustomer(long customerID) {

		Optional<Customer> customer = customerRepository.findById(customerID);
		
		
		if( customer.isPresent() )
			return customer.get();
					
		return null; // no customer. 			
		
	}

	@Override
	public List<Customer> retrieveAllCustomer() {
		
		return customerRepository.findAll();


	}

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

}
