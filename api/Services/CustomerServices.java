package customer.api.Services;

import java.util.List;


import customer.api.Models.Customer;

public interface CustomerServices{
	
	
	public List <Customer> getCustomers();
	
	public void addCustomer (Customer customer);
	
	public void updateCustomers(int id , Customer customer);
	
	public void delete (int id);
	
}
