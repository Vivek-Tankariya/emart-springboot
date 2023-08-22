package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Invoice;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
