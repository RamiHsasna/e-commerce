package com.ecommerce.springboot.api.controller.auth;

import com.ecommerce.springboot.api.model.RegistrationBody;
import com.ecommerce.springboot.exception.CustomerAlreadyExistsException;
import com.ecommerce.springboot.model.repo.CustomerRepo;
import com.ecommerce.springboot.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity registerCustomer(@Valid @RequestBody RegistrationBody registrationBody){
        try {
            customerService.registerCustomer(registrationBody);
            return ResponseEntity.ok().build();
        } catch (CustomerAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
