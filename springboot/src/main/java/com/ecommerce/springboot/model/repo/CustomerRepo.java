package com.ecommerce.springboot.model.repo;

import com.ecommerce.springboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Optional;

@RepositoryRestResource
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Optional<Customer> findByUsernameIgnoreCase(String username);
    Optional<Customer> findByEmailIgnoreCase(String email);
}
