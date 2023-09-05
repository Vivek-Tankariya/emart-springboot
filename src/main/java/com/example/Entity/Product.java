package com.example.Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_ID")
	private int prodID;
	
	@Column(nullable = false)
	private String prodName;
	
	@Column(nullable = false)
	private String prodShortDesc;
	
	@Column(nullable = false)
	private String prodLongDesc;
	
	@Column(nullable = false)
	private double mrpPrice;
	
	private double offerPrice;
	
	@Column(name = "cardHolderPrice", nullable = false)
	private double cardHolderPrice;
	
	@Column(name = "pointsRedeem", nullable = false)
	private int pointsRedeem;
	
	private String imgPath;
	
	@Column(name = "inventoryQuantity", nullable = false)
	private int inventoryQuantity;
	
	@Column(name = "disc", nullable = true, columnDefinition = "INT DEFAULT 0")
	private int Disc;
	
	public int getDisc() {
		return Disc;
	}

	public void setDisc(int disc) {
		Disc = disc;
	}
	@Column(name = "catmasterID", nullable = false)
	private int catMasterID;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_id")
	private List<ConfigDetails> configDetailsList;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_id")
	private List<InvoiceDetails> invoiceDetailsList;
	
	private List<Cart> cartList;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ProdID")
	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}



	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ProdID")
	public List<ConfigDetails> getConfig_details() {
		return configDetailsList;
	}
	
	

	public void setConfig_details(List<ConfigDetails> config_details) {
		this.configDetailsList = config_details;
	}
	

	public int getCatmasterID() {
		return catMasterID;
	}

	public void setCatmasterID(int catmasterID) {
		this.catMasterID = catmasterID;
	}

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "Prod_ID")
	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	@Column(nullable = false)
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Column(nullable = false)
	public String getProdShortDesc() {
		return prodShortDesc;
	}

	public void setProdShortDesc(String prodShortDesc) {
		this.prodShortDesc = prodShortDesc;
	}

	@Column(nullable = false)
	public String getProdLongDesc() {
		return prodLongDesc;
	}

	public void setProdLongDesc(String prodLongDesc) {
		this.prodLongDesc = prodLongDesc;
	}

	@Column(nullable = false)
	public double getMrpPrice() {
		return mrpPrice;
	}

	public void setMrpPrice(double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	public double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}

	@Column(nullable=false)
	public double getCardHolderPrice() {
		return cardHolderPrice;
	}

	public void setCardHolderPrice(double cardHolderPrice) {
		this.cardHolderPrice = cardHolderPrice;
	}

	@Column(nullable=false)
	public int getPointsRedeem() {
		return pointsRedeem;
	}

	public void setPointsRedeem(int pointsRedeem) {
		this.pointsRedeem = pointsRedeem;
	}

	
	public String getImgpath() {
		return imgPath;
	}

	public void setImgpath(String imgpath) {
		this.imgPath = imgpath;
	}

	@Column(nullable=false)
	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ProdID")
	public List<InvoiceDetails> getInvoiceDtList() {
		return invoiceDetailsList;
	}
	public void setInvoiceDtList(List<InvoiceDetails> invoiceDtList) {
		this.invoiceDetailsList = invoiceDtList;
	}
	
}

