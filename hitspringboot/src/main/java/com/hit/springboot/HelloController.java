package com.hit.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  private static Map<String, Product> productRepo = new HashMap<>();

  @RequestMapping(value = "/products", method = RequestMethod.POST)
  public ResponseEntity<Object> createProduct(@RequestBody Product product) {
    productRepo.put(product.getName(), product);
    
    return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
  }
  @RequestMapping(value = "/products")
  public ResponseEntity<Object> getProduct() {
     return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
  }
}
