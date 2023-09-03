package com.example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Entity.InvoiceDetails;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface Invoice_detailsRepository extends JpaRepository<InvoiceDetails, Integer> 
{
	
	@Query("SELECT i FROM InvoiceDetails i WHERE i.invoiceID = :inID")
    List<InvoiceDetails> findByInvID(@Param("inID") int inID);
}
