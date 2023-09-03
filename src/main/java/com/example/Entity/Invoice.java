package com.example.Entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Invoice")
public class Invoice {
	
	private int invoiceID;
	private Date InvoiceDate;
	
	private double totalAmt;
	private double tax;
	private double deliveryCharge;
	private double TotalBill;
	private int custID;
	private List<InvoiceDetails> InvoiceDtList;
	private List<Order> Olist;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Invoice_id")
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	
	
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	
	public double getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	
	public double getTotalBill() {
		return TotalBill;
	}
	public void setTotalBill(double totalBill) {
		TotalBill = totalBill;
	}
	
	
	
	
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="invoiceID")
	public List<InvoiceDetails> getInvoiceDtList() {
		return InvoiceDtList;
	}
	public void setInvoiceDtList(List<InvoiceDetails> invoiceDtList) {
		InvoiceDtList = invoiceDtList;
	}
	
	public Date getInvoiceDate() {
		return InvoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		InvoiceDate = invoiceDate;
	}
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="invoiceID")
	public List<Order> getOlist() {
		return Olist;
	}
	public void setOlist(List<Order> olist) {
		Olist = olist;
	}

}
