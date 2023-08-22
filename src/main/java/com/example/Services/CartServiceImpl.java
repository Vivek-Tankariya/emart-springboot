package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Cart;
import com.example.Repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;
	
	//Insert
	public Cart saveCart(Cart obj) {
		return cartRepo.save(obj);
	}
	
	//SelectAll
	public List<Cart> getAllCart() {
		return cartRepo.findAll();
	}
	
	//SelectById
	public Cart getCartById(int id) {
			
		return cartRepo.findById(id).get();
	}
	
	//Delete
	public void deleteCart(int id) {
			
			Cart c = cartRepo.findById(id).get();
			
			if(c!=null) {
				cartRepo.delete(c);
			}	
	}
	
	//Update
	public Cart updateCart(Cart c, int id) {
		Cart oldc =  cartRepo.findById(id).get();
		oldc.setProduct(c.getProduct());
		oldc.setQty(c.getQty());
		oldc.setTotalCost(c.getTotalCost());
		oldc.setDeliveryCharges(c.getDeliveryCharges());
		oldc.setDiscount(c.getDiscount());
		oldc.setTotalBill(c.getTotalBill());
		return cartRepo.save(oldc);
		
	}	
}
