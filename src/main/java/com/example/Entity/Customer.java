package com.example.Entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Customer")
public class Customer {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_ID")
	private int custID;
	
	@NotBlank(message = "Customer name must be entered")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Customer name must contain only characters")
	@Size(min = 4, max = 20, message = "Customer name must be between 4 to 20 characters")
	@Column(nullable = false)
	private String custName;
	
	@NotBlank(message = "Customer Address must be entered")
	@Column(nullable = false)
	private String custAddress;
	
	@NotBlank(message = "Customer Phone number must be entered")
	@Pattern(regexp = "^[0-9]+$", message = "Phone number must contain only numbers")
	@Size(min = 10, max = 10, message = "Phone number has to be 10 digits")
	@Column(nullable = false)
	private String custPhone;
	
	private String custEmail; // Add validation for email format
	
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Password must contain only numbers and letters")
	@Size(min = 10, max = 10, message = "Password has to be 10 characters")
	@Column(nullable = false)
	private String custPassword;
	
	@Column(nullable = false)
	private boolean cardHolder;
	
	@Column(nullable = false)
	private int points;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private List<Invoice> invoiceList;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private List<Order> orderList;
		
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	
	@Column(nullable = false)
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	@Column(nullable = false)
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	@Column(nullable = false)
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	@Column(nullable = false)
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	@Column(nullable = false)
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	
	@Column(nullable=false)
	public boolean isCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(boolean isCardHolder) {
		this.cardHolder = isCardHolder;
	}
	
	@Column(nullable = false)
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CustID")
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="CustID")
	public List<Invoice> getIlist() {
		return invoiceList;
	}
	public void setIlist(List<Invoice> ilist) {
		this.invoiceList = ilist;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="CustID")
	public List<Order> getOlist() {
		return orderList;
	}
	public void setOlist(List<Order> olist) {
		this.orderList = olist;
	}
}
