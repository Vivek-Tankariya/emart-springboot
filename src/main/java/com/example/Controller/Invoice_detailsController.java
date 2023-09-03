package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Entity.InvoiceDetails;
import com.example.Services.Invoice_detailsService;


@RestController
@CrossOrigin
@RequestMapping("/api/Invoicedetaails")
public class Invoice_detailsController 
{
	@Autowired
	private Invoice_detailsService invoicedetailRepository;
	
	@GetMapping
	public ResponseEntity<?> getAllInvoice_detailss(){
		return new ResponseEntity<> (invoicedetailRepository.getAllInvoice_detailss(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{invoicedetId}")
	public ResponseEntity<?> getInvoice_detailsId(@PathVariable int Invoice_detailsId) {
		return new ResponseEntity<> (invoicedetailRepository.getInvoice_detailsById(Invoice_detailsId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addInvoice_details(@RequestBody InvoiceDetails Invoice_details) {
		return new ResponseEntity<> (invoicedetailRepository.addInvoice_details(Invoice_details),HttpStatus.OK);
	}
	
	@PutMapping("/{invoicedetId}")
	public ResponseEntity<?> updateInvoice_details(@PathVariable int Invoice_detailsId,@RequestBody InvoiceDetails updatedInvoice_details) {
		return new ResponseEntity<> (invoicedetailRepository.updateInvoice_details(Invoice_detailsId,updatedInvoice_details),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{invoicedetId}")
      public void deleteInvoice_details(@PathVariable int Invoice_detailsId) {
    	  invoicedetailRepository.deleteInvoice_details(Invoice_detailsId);
      }
	
	@GetMapping("/InvoiceID/{invID}")
		public List<InvoiceDetails> findByInvID(@PathVariable int invID) {
	  	  return invoicedetailRepository.GetDetails(invID);
	    }
	

}
