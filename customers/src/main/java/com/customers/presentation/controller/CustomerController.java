package com.customers.presentation.controller;

import java.util.List;

import com.customers.domain.dto.CustomerCreateDto;
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

@RestController
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAllCustomer(){
		List<CustomerDto> response = customerService.getCustomers();
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<CustomerCreateDto> createCustomer(@RequestBody CustomerCreateDto customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
	}
	
	@PutMapping("{customerId}")
	public ResponseEntity<CustomerCreateDto> modifyCustomer(@PathVariable("customerId") int id,@RequestBody CustomerCreateDto customer) {
		return new ResponseEntity<CustomerCreateDto>(customerService.updateCustomers(id,customer), HttpStatus.OK);
	}
	
	@DeleteMapping("{customerId}")
	public ResponseEntity<CustomerCreateDto> deleteCustomer (@PathVariable("customerId") int id) {
		return new ResponseEntity<>(customerService.delete(id),HttpStatus.FORBIDDEN);
	}
	
}
