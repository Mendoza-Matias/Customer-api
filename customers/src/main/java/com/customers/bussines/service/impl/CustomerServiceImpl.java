package com.customers.bussines.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customers.bussines.service.ICustomerService;
import com.customers.domain.entity.Customer;
import com.customers.persistence.ICategoriaRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICategoriaRepository repository;

	@Override
	public List<Customer> getCustomers() {
		return repository.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer newCustomer = repository.save(customer);
		
		return newCustomer;
	}

	@Override
	public Customer updateCustomers(int id, Customer customer) {
		
		Customer customerModify = null;
		
		if(repository.findById(id).isPresent()) {
			
			customerModify = repository.findById(id).get();
			
			customerModify.setName(customer.getName());
			customerModify.setLastName(customer.getLastName());
			customerModify.setAge(customer.getAge());
			customerModify.setTel(customer.getTel());
			
			/*modification of the customer*/
			
			repository.save(customerModify);
		}
		
		return customerModify;
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	
}
