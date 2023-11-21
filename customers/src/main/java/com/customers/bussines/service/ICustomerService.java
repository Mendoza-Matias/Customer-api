package com.customers.bussines.service;

import java.util.List;

import com.customers.domain.dto.CustomerDto;
import com.customers.domain.entity.Customer;


public interface ICustomerService {
	
	
	
	public List <CustomerDto> getCustomers();
	
	public Customer addCustomer (Customer customer);
	
	public Customer updateCustomers(int id , Customer customer);
	
	public Customer delete (int id);
	
	
}
