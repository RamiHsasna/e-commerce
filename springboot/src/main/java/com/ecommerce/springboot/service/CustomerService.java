package com.ecommerce.springboot.service;


import com.ecommerce.springboot.api.model.LoginBody;
import com.ecommerce.springboot.api.model.RegistrationBody;
import com.ecommerce.springboot.exception.CustomerAlreadyExistsException;
import com.ecommerce.springboot.model.Customer;
import com.ecommerce.springboot.model.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;
    private EncryptionService encryptionService;
    private JWTService jwtService;

    public CustomerService(CustomerRepo customerRepo, EncryptionService encryptionService, JWTService jwtService) {
        this.customerRepo = customerRepo;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }


    public Customer registerCustomer(RegistrationBody registrationBody) throws CustomerAlreadyExistsException {

        if (customerRepo.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || customerRepo.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new CustomerAlreadyExistsException();
        };

        Customer customer = new Customer();
        customer.setCustomer_id(registrationBody.getCustomer_id());
        customer.setUsername(registrationBody.getUsername());
        customer.setFirstName(registrationBody.getFirstname());
        customer.setLastName(registrationBody.getLastname());
        customer.setMail(registrationBody.getEmail());
        customer.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return customerRepo.save(customer);
    }
    public String loginCustomer(LoginBody loginBody){
        Optional<Customer> opCustomer = customerRepo.findByUsernameIgnoreCase(loginBody.getUsername());
        if (opCustomer.isPresent()){
            Customer customer = opCustomer.get();
            if(EncryptionService.verifyPassword(loginBody.getPassword(),customer.getPassword())){
                return jwtService.generateJWT(customer);
            }
        }
        return null;
    }
}
