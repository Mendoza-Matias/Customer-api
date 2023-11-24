package com.customers.bussines.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.customers.domain.dto.CustomerCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customers.bussines.service.ICustomerService;
import com.customers.domain.dto.CustomerDto;
import com.customers.domain.entity.Customer;
import com.customers.persistence.ICategoriaRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICategoriaRepository repository;

	@Override
	public List<CustomerDto> getCustomers() {
		return repository.findAll().stream()
				.map(customer -> new CustomerDto(customer.getId(), customer.getName(), customer.getLastName()))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerCreateDto addCustomer (CustomerCreateDto customer) {

		Customer customerEntity = new Customer();
		customerEntity.setName(customer.getName());
		customerEntity.setLastName(customer.getLastName());
		customerEntity.setAge(customer.getAge());
		customerEntity.setTel(customer.getTel());

		repository.save(customerEntity);

		CustomerCreateDto customerCreateDto = new CustomerCreateDto();
		customerCreateDto.setName(customer.getName());
		customerCreateDto.setLastName(customer.getLastName());
		customerCreateDto.setTel(customer.getTel());
		customerCreateDto.setAge(customer.getAge());

		return customerCreateDto;
	}

	@Override
	public CustomerCreateDto updateCustomers(int id, CustomerCreateDto customer) {

		Customer customerExist = null;

		if (repository.findById(id).isPresent()) {

			customerExist = repository.findById(id).get();

			customerExist.setName(customer.getName());
			customerExist.setLastName(customer.getLastName());
			customerExist.setAge(customer.getAge());
			customerExist.setTel(customer.getTel());

			/* modification of the customer */

			repository.save(customerExist);

		}

		CustomerCreateDto customerCreateDto = new CustomerCreateDto();
		customerCreateDto.setName(customer.getName());
		customerCreateDto.setLastName(customer.getLastName());
		customerCreateDto.setTel(customer.getTel());
		customerCreateDto.setAge(customer.getAge());

		return customerCreateDto;
	}

	@Override
	public CustomerCreateDto delete (int id) {

		Optional <Customer> customer = repository.findById(id);

		if (customer.isPresent()) {

			CustomerCreateDto customerData = new CustomerCreateDto();
			Customer customerExist = customer.get();

			customerData.setName(customerExist.getName());
			customerData.setLastName(customerExist.getLastName());
			customerData.setTel(customerExist.getTel());
			customerData.setAge(customerData.getAge());

			repository.deleteById(id);

			return customerData;

		} else {
			return null;
		}

	}

}
