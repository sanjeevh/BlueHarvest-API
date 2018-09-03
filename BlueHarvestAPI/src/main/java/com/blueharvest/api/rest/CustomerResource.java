package com.blueharvest.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.blueharvest.api.model.Customer;
import com.blueharvest.api.service.customer.CustomerService;

@RestController
public class CustomerResource {


	
	@Autowired
	private CustomerService CustomerService;

	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		
		return CustomerService.retrieveAllCustomer();
	}

	@GetMapping("/customers/{id}")
	public Customer retrieveCustomer(@PathVariable long id) {
		
		return CustomerService.retrieveCustomer(id);
	}

	

}
