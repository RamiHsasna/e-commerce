package com.ecommerce.springboot;

import com.ecommerce.springboot.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.springboot.model.Customer;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepo repo;

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }
}
