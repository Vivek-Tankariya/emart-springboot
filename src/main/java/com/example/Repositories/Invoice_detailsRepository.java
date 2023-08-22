package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.InvoiceDetails;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface Invoice_detailsRepository extends JpaRepository<InvoiceDetails, Integer> 
{

}
