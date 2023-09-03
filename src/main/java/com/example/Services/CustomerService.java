package com.example.Services;

import java.util.List;
import java.util.Optional;

import com.example.Entity.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer c);
	public List<Customer>getAllCustomers();
	public void deleteCustomer(int cid);
	public Customer update(Customer c,int cid);
	public Customer getCustomerById(int cid);
	Optional<Customer> getCustomerByEmail(String email);
	List<Customer> getPrimeCustomers();
	int checkCust(String e, String p);
	boolean checkCardHolder(int id);
	int getPointsByID(int id);

}
