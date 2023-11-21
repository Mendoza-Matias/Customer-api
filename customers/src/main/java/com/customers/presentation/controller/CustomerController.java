package com.customers.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customers.bussines.service.ICustomerService;
import com.customers.domain.dto.CustomerDto;
import com.customers.domain.entity.Customer;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAllCustomer(){
		List<CustomerDto> response = customerService.getCustomers();
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer response = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(response,HttpStatus.OK);
	}
	
	@PutMapping("{customerId}")
	public ResponseEntity<Customer >modifyCustomer(@PathVariable("customerId") int id,@RequestBody Customer customer) {
		Customer response = customerService.updateCustomers(id, customer);
		return new ResponseEntity<Customer>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") int id) {
		Customer response = customerService.delete(id);
		return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
	}
	
}
