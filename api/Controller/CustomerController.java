package customer.api.Controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import customer.api.Models.Customer;
import customer.api.Services.CustomerServiceImpl;
import customer.api.Services.CustomerServices;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

	public final CustomerServices service;

	public CustomerController(CustomerServiceImpl service) {
		this.service = service;
	}

	@GetMapping
	public List<Customer> get() {
		return service.getCustomers();
	}

	@PostMapping
	public void post(@RequestBody Customer customer) {
		service.addCustomer(customer);
	}

	@PutMapping("{customerId}")
	public void add(@PathVariable("customerId") int id, @RequestBody Customer customer) {
		service.updateCustomers(id, customer);
	}

	@DeleteMapping("{customerId}")
	public void delete(@PathVariable("customerId") int id) {
		service.delete(id);
	}

}
