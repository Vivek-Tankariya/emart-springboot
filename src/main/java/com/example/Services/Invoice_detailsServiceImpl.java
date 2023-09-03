package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.InvoiceDetails;
import com.example.Repositories.Invoice_detailsRepository;

@Service
public class Invoice_detailsServiceImpl implements Invoice_detailsService
{
	@Autowired
	private Invoice_detailsRepository indetailRepository;

	@Override
	public List<InvoiceDetails> getAllInvoice_detailss() {
		// TODO Auto-generated method stub
		return indetailRepository.findAll();
	}

	@Override
	public InvoiceDetails getInvoice_detailsById(int invoice_detailsId) {
		// TODO Auto-generated method stub
		return indetailRepository.findById(invoice_detailsId).get();
	}

	@Override
	public InvoiceDetails addInvoice_details(InvoiceDetails invoice_details) {
		// TODO Auto-generated method stub
		return indetailRepository.save(invoice_details);
	}

	@Override
	public InvoiceDetails updateInvoice_details(int invoice_detailsId, InvoiceDetails updatedInvoice_details) {
		
		 InvoiceDetails existingInvoiceDetails = indetailRepository.findById(invoice_detailsId).orElse(null);

	        if (existingInvoiceDetails != null) {
	            // Update the fields of the existing invoice details with the values from the updated invoice details
	            existingInvoiceDetails.setMrp(updatedInvoice_details.getMrp());
	            existingInvoiceDetails.setCardHolderPrice(updatedInvoice_details.getCardHolderPrice());
	            existingInvoiceDetails.setPointsRedeem(updatedInvoice_details.getPointsRedeem());
	            existingInvoiceDetails.setInvoiceID(updatedInvoice_details.getInvoiceID());
	            existingInvoiceDetails.setProdID(updatedInvoice_details.getProdID());

	            // Save the updated invoice details back to the database
	            return indetailRepository.save(existingInvoiceDetails);
	        }

	        return null;
	}

	@Override
	public void deleteInvoice_details(int invoice_detailsId) {
		InvoiceDetails c=indetailRepository.findById(invoice_detailsId).get();
		if(c!=null)
		{
			indetailRepository.delete(c);
		}
		
	}
	
	public List<InvoiceDetails> GetDetails (int invoiceID){
		return indetailRepository.findByInvID(invoiceID);
	}

}
