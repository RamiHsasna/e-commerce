package com.ecommerce.springboot;

import com.ecommerce.springboot.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.springboot.model.Cart;

@RestController
public class CartController {
    @Autowired
    CartRepo repo;
    @PostMapping("/addCart")
    public void addCart(@RequestBody Cart Cart){

        repo.save(Cart);
    }
}
