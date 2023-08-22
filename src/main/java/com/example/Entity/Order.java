package com.example.Entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="Orders")
public class Order {

	private int OrderID;
	private String ShippingAdd;
	private Date OrderDate;
	private Date Deliverydate;
	
	private int CustID;
	private int invoiceID;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Order_ID")
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	
	
	public String getShippingAdd() {
		return ShippingAdd;
	}
	public void setShippingAdd(String shippingAdd) {
		ShippingAdd = shippingAdd;
	}
	
	
	public int getCustID() {
		return CustID;
	}
	public void setCustID(int custID) {
		CustID = custID;
	}
	
	
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	
	
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public Date getDeliverydate() {
		return Deliverydate;
	}
	public void setDeliverydate(Date deliverydate) {
		Deliverydate = deliverydate;
	}

	
	
}
