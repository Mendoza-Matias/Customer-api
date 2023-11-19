package com.customers.bussines.service;

import java.util.List;
import com.customers.domain.entity.Customer;


public interface ICustomerService {
	
	
	
	public List <Customer> getCustomers();
	
	public Customer addCustomer (Customer customer);
	
	public Customer updateCustomers(int id , Customer customer);
	
	public void delete (int id);
	
	
}
