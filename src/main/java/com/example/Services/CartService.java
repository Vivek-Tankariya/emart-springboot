package com.example.Services;

import java.util.List;

import com.example.Entity.Cart;

public interface CartService {
	Cart saveCart(Cart obj);
	List<Cart> getAllCart();
	Cart getCartById(int id);
	void deleteCart(int id);
	Cart updateCart(Cart c, int id);
	List<Cart> findProdByCustID(int cid);
	int UpdateQty (int QT,int cid);
	int DeletecartByCustID (int cid);
}
