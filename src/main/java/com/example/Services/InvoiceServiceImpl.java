package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Invoice;
import com.example.Repositories.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService  {

	@Autowired
	private InvoiceRepository invoiceRepo;
	
	//Insert
		public Invoice saveInvoice(Invoice obj) {
			return invoiceRepo.save(obj);
		}
		
		//SelectAll
		public List<Invoice> getAllInvoice() {
			return invoiceRepo.findAll();
		}
		
		//SelectById
		public Invoice getInvoiceById(int id) {
				
			return invoiceRepo.findById(id).get();
		}
		
		//Delete
		public void deleteInvoice(int id) {
				
				Invoice i = invoiceRepo.findById(id).get();
				
				if(i!=null) {
					invoiceRepo.delete(i);
				}	
		}
		
		//Update
		public Invoice updateInvoice(Invoice i, int id) {
			Invoice oldi =  invoiceRepo.findById(id).get();
			oldi.setCustID(i.getCustID());
			oldi.setTotalAmt(i.getTotalAmt());
			oldi.setTax(i.getTax());
			oldi.setDeliveryCharge(i.getDeliveryCharge());
			oldi.setDiscount(i.getDiscount());
			oldi.setTotalAmt(i.getTotalAmt());
			
			return invoiceRepo.save(oldi);
			
		}	
	
}
