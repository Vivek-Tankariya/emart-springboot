package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Invoice_details")
public class InvoiceDetails {

	private int InvoiceDtID;
	private double mrp;
	private double CardHolderPrice;
	private int PointsRedeem;
	private int invoiceID;
	private int ProdID;
	private String prodName;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "InvoiceDt_ID")
	public int getInvoiceDtID() {
		return InvoiceDtID;
	}
	public void setInvoiceDtID(int invoiceDtID) {
		InvoiceDtID = invoiceDtID;
	}
	
	
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	
	
	public double getCardHolderPrice() {
		return CardHolderPrice;
	}
	public void setCardHolderPrice(double cardHolderPrice) {
		CardHolderPrice = cardHolderPrice;
	}
	
	
	public int getPointsRedeem() {
		return PointsRedeem;
	}
	public void setPointsRedeem(int pointsRedeem) {
		PointsRedeem = pointsRedeem;
	}
	
	
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	
	
	public int getProdID() {
		return ProdID;
	}
	public void setProdID(int prodID) {
		ProdID = prodID;
	}
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	
}
