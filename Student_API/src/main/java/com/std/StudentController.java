package com.std;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StudentController {
	  
	private static Map<String, Student> productRepo = new HashMap<>();
	   static {
		   Student honey = new Student();
	      honey.setStd_rollno("1");
	      honey.setStd_name("Honey");
	      honey.setStd_class("A");
	      honey.setStd_city("Nashik");
	      honey.setStd_gender("Male");
	      productRepo.put(honey.getStd_rollno(), honey);
	      
	      Student almond = new Student();
	      almond.setStd_rollno("2");
	      almond.setStd_name("Almond");
	      almond.setStd_class("B");
	      almond.setStd_city("Pune");
	      almond.setStd_gender("Female");
	      productRepo.put(almond.getStd_rollno(), almond);
	   }
	  @RequestMapping(value = "/products/{std_rollno}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("std_rollno") String std_rollno) { 
	      productRepo.remove(std_rollno);
	    return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/products/{std_rollno}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("std_rollno") String std_rollno, @RequestBody Student product) { 
	      productRepo.remove(std_rollno);
	      product.setStd_rollno(std_rollno);
	      productRepo.put(std_rollno, product);
	   return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	   }   
	   @RequestMapping(value = "/products", method = RequestMethod.POST)
	   public ResponseEntity<Object> createProduct(@RequestBody Student product) {
	      productRepo.put(product.getStd_rollno(), product);
	 return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   }
	   @RequestMapping(value = "/products")
	   public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	   }
}

