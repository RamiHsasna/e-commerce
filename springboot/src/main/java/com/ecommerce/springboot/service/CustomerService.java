package com.ecommerce.springboot.service;


import com.ecommerce.springboot.api.model.RegistrationBody;
import com.ecommerce.springboot.exception.CustomerAlreadyExistsException;
import com.ecommerce.springboot.model.Customer;
import com.ecommerce.springboot.model.repo.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
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
        //TODO : Encrypt passwords !!
        customer.setPassword(registrationBody.getPassword());
        return customerRepo.save(customer);
    }
}
