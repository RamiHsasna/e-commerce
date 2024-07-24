package com.ecommerce.springboot.api.controller.auth;

import com.ecommerce.springboot.api.model.RegistrationBody;
import com.ecommerce.springboot.model.repo.CustomerRepo;
import com.ecommerce.springboot.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthentificationController {

    private final CustomerService customerService;
    private CustomerRepo customerRepo;

    public AuthentificationController(CustomerRepo customerRepo, CustomerService customerService) {
        this.customerRepo = customerRepo;
        this.customerService = customerService;
    }


    @PostMapping("/register")
    public void registerCustomer(@RequestBody RegistrationBody registrationBody){
        customerService.registerCustomer(registrationBody);
    }
}
