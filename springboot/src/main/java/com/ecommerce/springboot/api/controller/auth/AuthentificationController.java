package com.ecommerce.springboot.api.controller.auth;

import com.ecommerce.springboot.api.model.LoginBody;
import com.ecommerce.springboot.api.model.LoginResponse;
import com.ecommerce.springboot.api.model.RegistrationBody;
import com.ecommerce.springboot.exception.CustomerAlreadyExistsException;
import com.ecommerce.springboot.model.repo.CustomerRepo;
import com.ecommerce.springboot.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginCustomer(@Valid @RequestBody LoginBody loginBody){
        String jwt = customerService.loginCustomer(loginBody);
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            return ResponseEntity.ok(response);
        }
    }
}
