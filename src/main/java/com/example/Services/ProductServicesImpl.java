package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Category;
import com.example.Entity.Product;
import com.example.Repositories.ProductRepository;

@Service
public class ProductServicesImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int productId) {
		
		return productRepository.findById(productId).get(); 
	}

	@Override
	public Product addProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		Product c = productRepository.findById(productId).get();
		
		if(c!=null) {
		   productRepository.delete(c);
		}	
		
	}

    @Override
   
    public Product updateProduct(int productId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId).orElse(null);

        if (existingProduct != null) {
            existingProduct.setProdName(updatedProduct.getProdName());
            existingProduct.setProdShortDesc(updatedProduct.getProdShortDesc());
            existingProduct.setProdLongDesc(updatedProduct.getProdLongDesc());
            existingProduct.setMrpPrice(updatedProduct.getMrpPrice());
            existingProduct.setOfferPrice(updatedProduct.getOfferPrice());
            existingProduct.setCardHolderPrice(updatedProduct.getCardHolderPrice());
            existingProduct.setPointsRedeem(updatedProduct.getPointsRedeem());
            existingProduct.setImgpath(updatedProduct.getImgpath());
            existingProduct.setInventoryQuantity(updatedProduct.getInventoryQuantity());

           
            return productRepository.save(existingProduct);
        }

        return null;
    }
    
    @Override
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findProductsByMrpPriceBetween(minPrice, maxPrice);
    }
     
    @Override
    public List<Product> getProductsWithValidDiscount() {
        return productRepository.findProductsWithValidDiscount();
    }
    
    @Override
	public List<Product> findByCatID(int id) {
		// TODO Auto-generated method stub
		return productRepository.findByCatID(id);
	}

}
