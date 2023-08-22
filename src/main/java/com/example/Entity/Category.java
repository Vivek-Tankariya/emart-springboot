package com.example.Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Category")
public class Category {
	
	private int catmasterID;
		
	private String categoryName;
		
	private boolean childflag;
	
	private int parentCatID;
	
	private String catImgPath;
	
	private List<Product> Product;
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATMASTER_ID")
	public int getCatmasterID() {
		return catmasterID;
	}

	public void setCatmasterID(int catmasterID) {
		this.catmasterID = catmasterID;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="catmasterID")
	public List<Product> getProduct() {
		return Product;
	}

	public void setProduct(List<Product> product) {
		Product = product;
	}

	@Column(nullable = false)
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(nullable = false)
	public boolean getchildflag() {
		return childflag;
	}

	public void setchildflag(boolean childflag) {
		this.childflag = childflag;
	}

	public int getParentCatID() {
		return parentCatID;
	}

	public void setParentCatID(int parentCatID) {
		this.parentCatID = parentCatID;
	}

	@Column(nullable=false)
	public String getCatImgPath() {
		return catImgPath;
	}

	public void setCatImgPath(String catImgPath) {
		this.catImgPath = catImgPath;
	}
	
}
