package com.example.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository <Customer,Integer> {

	@Query(value = "SELECT * FROM Customer c WHERE c.cust_email = :custEmail", nativeQuery = true)
	Optional<Customer> getCustomerByEmail(@Param("custEmail") String custEmail);

	
	List<Customer> findByCardHolderTrue();
	
	@Query(value = "SELECT c.custID FROM Customer c WHERE c.custEmail = :e and c.custPassword = :p")
	int checkCust(@Param("e") String e, @Param("p") String p);
	
	@Query(value = "SELECT c.cardHolder FROM Customer c WHERE c.custID = :cid")
	boolean checkCardHolder(@Param("cid") int cid);
	
	@Query(value = "SELECT c.points FROM Customer c WHERE c.custID = :cid")
	int getPointsByID(@Param("cid") int cid);
	
}
