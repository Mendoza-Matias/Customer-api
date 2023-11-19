package com.customers.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customers.bussines.service.ICustomerService;
import com.customers.domain.entity.Customer;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.getCustomers(); 
	}
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		
		return customerService.addCustomer(customer);
	}
	
	@PutMapping("{customerId}")
	public Customer modifyCustomer(@PathVariable("customerId") int id,@RequestBody Customer customer) {
		Customer customerModify = customerService.updateCustomers(id, customer);
		return customerModify;
	}
	
	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int id) {
		customerService.delete(id);		
	}
	
}
