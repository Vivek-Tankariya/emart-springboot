package com.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Cart")

public class Cart {

	private int CartID;
	private int CustID;
	
	private int Qty;
	private double TotalCost;
	private double DeliveryCharges;
	private double discount;
	private double totalBill;
	
	private Product product;
	
	public double getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(double totalCost) {
		TotalCost = totalCost;
	}
	
	public double getDeliveryCharges() {
		return DeliveryCharges;
	}
	public void setDeliveryCharges(double deliveryCharges) {
		DeliveryCharges = deliveryCharges;
	}
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "cart_ID")
	public int getCartID() {
		return CartID;
	}
	public void setCartID(int cartID) {
		CartID = cartID;
	}
	
	
	public int getCustID() {
		return CustID;
	}
	public void setCustID(int custID) {
		CustID = custID;
	}
	
	
	@Column(nullable=false)
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}	
	
	@ManyToOne
	@JoinColumn(name = "ProdID")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
