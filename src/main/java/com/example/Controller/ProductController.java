package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Entity.Product;
import com.example.Services.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<?> getAllProducts(){
		return new ResponseEntity<> ( productService.getAllProducts(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductId(@PathVariable int productId) {
		return new ResponseEntity<> (productService.getProductById(productId),HttpStatus.OK);
	}
	
	@GetMapping("/byPriceRange")
    public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
	
	 @GetMapping("/withValidDiscount")
	    public ResponseEntity<List<Product>> getProductsWithValidDiscount() {
	        List<Product> products = productService.getProductsWithValidDiscount();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return new ResponseEntity<> (productService.addProduct(product),HttpStatus.OK);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable int productId,@RequestBody Product updatedProduct) {
		return new ResponseEntity<> ( productService.updateProduct(productId,updatedProduct),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{productId}")
      public void deleteproduct(@PathVariable int productId) {
    	  productService.deleteProduct(productId);
      }
	
	@GetMapping("/getCatId/{Id}")
	public ResponseEntity<?> findByCatID(@PathVariable int Id) {
		return new ResponseEntity<> (productService.findByCatID(Id),HttpStatus.OK);
	}
	

}
