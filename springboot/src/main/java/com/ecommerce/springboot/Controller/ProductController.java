package com.ecommerce.springboot.Controller;

import com.ecommerce.springboot.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.springboot.model.Product;

@RestController
public class ProductController {
    @Autowired
    ProductRepo repo;

    @PostMapping("/addProduct")
    public void addCustomer(@RequestBody Product product) {
        repo.save(product);
    }
}
