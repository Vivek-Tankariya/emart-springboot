package com.example.Services;

import java.util.List;

import com.example.Entity.InvoiceDetails;

public interface Invoice_detailsService 
{

	List<InvoiceDetails> getAllInvoice_detailss();

	InvoiceDetails getInvoice_detailsById(int invoice_detailsId);

	InvoiceDetails addInvoice_details(InvoiceDetails invoice_details);

	InvoiceDetails updateInvoice_details(int invoice_detailsId, InvoiceDetails updatedInvoice_details);

	void deleteInvoice_details(int invoice_detailsId);
	
	List<InvoiceDetails> GetDetails (int invoiceID);

}
