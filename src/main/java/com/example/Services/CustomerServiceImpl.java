package com.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.Entity.Category;
import com.example.Entity.Customer;
import com.example.Repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepo;
	

	public Customer saveCustomer(Customer c)
	{
		return customerRepo.save(c);
	}
	
	 public Customer getCustomerById(int cid)
	 {
		return customerRepo.findById(cid).get();
	 }
	
	public List<Customer>getAllCustomers()
	{
		return customerRepo.findAll();
	}
	
	
	public void deleteCustomer(int id)
	{
		Customer cust = customerRepo.findById(id).get();
		
		if(cust!=null) {
		 customerRepo.delete(cust);
		}
	}
	
	@Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepo.getCustomerByEmail(email);
    }
	
	

    @Override
    public List<Customer> getPrimeCustomers() {
        return customerRepo.findByCardHolderTrue();
    }
	
	public Customer update(Customer c,int cid)
	{
		
		 Customer cust = customerRepo.findById(cid).get();
		 cust.setCustName(c.getCustName());
		 cust.setCustPhone(c.getCustPhone());
		 cust.setCustAddress(c.getCustAddress());
		 cust.setCustEmail(c.getCustEmail());
		 return customerRepo.save(cust);
		
	}
	
	public int checkCust(String e, String p) {
		
		return customerRepo.checkCust(e,p);
	}
	
	public boolean checkCardHolder(int id) {
		return customerRepo.checkCardHolder(id);
	}
	
	public int getPointsByID(int id) {
		return customerRepo.getPointsByID(id);
	}
	
	
}
