package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Entity.Cart;
import com.example.Services.CartService;

@RestController
@CrossOrigin
@RequestMapping("/api/Cart")
public class CartController {

	@Autowired
	private CartService cartServ;
	
	@PostMapping
	public ResponseEntity<?> AddCart (@RequestBody Cart c){
		return new ResponseEntity<> (cartServ.saveCart(c),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCart (){
		return new ResponseEntity<> (cartServ.getAllCart(),HttpStatus.OK);
	}
	
	@GetMapping("/{CartId}")
	public ResponseEntity<?> getCartByID(@PathVariable int id){
		return new ResponseEntity<> (cartServ.getCartById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{CartId}")
	public void deleteCart(@PathVariable int CartId){
		cartServ.deleteCart(CartId);
	}
	
	@PutMapping("/{Cartid}")
	public ResponseEntity<?> editCart (@RequestBody Cart c,@PathVariable int id){
		return new ResponseEntity<> (cartServ.updateCart(c, id),HttpStatus.CREATED);
	}
	
	@GetMapping("/cust/{cid}")
	public ResponseEntity<?> getProdByCustID(@PathVariable int cid){
		return new ResponseEntity<> (cartServ.findProdByCustID(cid),HttpStatus.OK);
	}
	
	@PutMapping("/{qty}/{Cartid}")
	public ResponseEntity<?> UpdateQty (@PathVariable int qty, @PathVariable int Cartid){
		return new ResponseEntity<> (cartServ.UpdateQty(qty, Cartid),HttpStatus.OK);
	}
	
	@DeleteMapping("/Deletecust/{CustId}")
	public ResponseEntity<?> DeletecartByCustID(@PathVariable int CustId){
		return new ResponseEntity<> (cartServ.DeletecartByCustID(CustId),HttpStatus.OK);
	}
	
}
