package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Entity.Category;
import com.example.Services.CategoryService;


@RestController
@CrossOrigin
@RequestMapping("/api/Category")
public class CategoryController 
{
	@Autowired
	private CategoryService categoryService ;
	
	@GetMapping
	public ResponseEntity<?> getAllCategorys(){
		return new ResponseEntity<> ( categoryService.getAllCategorys(),HttpStatus.OK);
		}
	
	
	@GetMapping("/{CategoryId}")
	public ResponseEntity<?> getCategoryId(@PathVariable int CategoryId) {
		return new ResponseEntity<> (categoryService.getCategoryById(CategoryId),HttpStatus.OK);
	}
	
	@GetMapping("/byName/{categoryName}")
    public ResponseEntity<List<Category>> getCategoriesByCategoryName(@PathVariable String categoryName) {
        List<Category> categories = categoryService.getCategoriesByCategoryName(categoryName);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
	
	@PostMapping 
	public ResponseEntity<?> addCategory(@RequestBody Category Category) {
		return new ResponseEntity<>( categoryService.addCategory(Category),HttpStatus.CREATED);
	}
	
	@PutMapping("/{CategoryId}")
	public ResponseEntity<?> updateCategory(@PathVariable int CategoryId,@RequestBody Category updatedCategory) {
		return new ResponseEntity<> (categoryService.updateCategory(CategoryId, updatedCategory),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{CategoryId}")
      public void deleteCategory(@PathVariable int CategoryId) {
    	  categoryService.deleteCategory(CategoryId);
      }
	
	
	

}
