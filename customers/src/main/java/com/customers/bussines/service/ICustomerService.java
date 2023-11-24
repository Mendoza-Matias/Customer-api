package com.customers.bussines.service;

import java.util.List;

import com.customers.domain.dto.CustomerCreateDto;
import com.customers.domain.dto.CustomerDto;


public interface ICustomerService {
	
	
	
	public List <CustomerDto> getCustomers();
	
	public  CustomerCreateDto addCustomer (CustomerCreateDto customer);
	
	public CustomerCreateDto updateCustomers(int id , CustomerCreateDto customer);
	
	public CustomerCreateDto delete (int id);
	
	
}
