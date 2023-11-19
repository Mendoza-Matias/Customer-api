package customer.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import customer.api.Models.Customer;
import customer.api.Repositories.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerServices {

	public final CustomerRepository customerRepository;
	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	
	@Override
	public void addCustomer(Customer customer) {
		
		customerRepository.save(customer);
	}


	@Override
	public void updateCustomers(int id, Customer customer) {
		
		if(customerRepository.findById(id).isPresent()) {
			
			Customer customerExist = customerRepository.findById(id).get();
			
			customerExist.setName(customer.getName());
			customerExist.setEmail(customer.getEmail());
			customerExist.setAge(customer.getAge());
			
			customerRepository.save(customerExist);
			
		}
		
	}


	@Override
	public void delete(int id) {
		
		customerRepository.deleteById(id);
	}
	

}
