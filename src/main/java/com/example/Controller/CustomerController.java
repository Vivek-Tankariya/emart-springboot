package com.example.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Entity.Auth;
import com.example.Entity.Customer;
import com.example.Services.CustomerService;

@RestController
@RequestMapping("/api/Customer")
@CrossOrigin()
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<?> getAllCustomers()
	{
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/{CustomerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable int CustomerId )
	{
		return new ResponseEntity<>(customerService.getCustomerById(CustomerId),HttpStatus.OK);
	}
	
	@GetMapping("/byEmail/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Optional<Customer> customer = customerService.getCustomerByEmail(email);
        
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/prime")
    public ResponseEntity<List<Customer>> getPrimeCustomers() {
        List<Customer> primeCustomers = customerService.getPrimeCustomers();
        return new ResponseEntity<>(primeCustomers,HttpStatus.OK);
    }
	
	
	@PostMapping
	public  ResponseEntity<?>AddCustomer(@RequestBody Customer c)
	{
		return new ResponseEntity<>(customerService.saveCustomer(c),HttpStatus.CREATED);
	}
	
	@PutMapping("/{Customerid}")
	public ResponseEntity<?> EditCustomer(@RequestBody Customer c,@PathVariable int id )
	{
		return new ResponseEntity<>(customerService.update(c, id),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{Customerid}")
	public void deleteCustomer(@PathVariable int id)
	{
		customerService.deleteCustomer(id);
	}
	
	@PostMapping("/check")
	public int checkCust(@RequestBody Auth a) {
		return customerService.checkCust(a.getCustEmail(), a.getCustPassword());
	}
	
	@GetMapping("/isCardHolder/{cid}")
    public boolean checkCardHolder(@PathVariable int cid) {
        
        return customerService.checkCardHolder(cid);
    }
	
	@GetMapping("/points/{cid}")
    public int getPointsByID(@PathVariable int cid) {
        
        return customerService.getPointsByID(cid);
    }
	
	

}