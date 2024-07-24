package com.ecommerce.springboot.model.repo;

import com.ecommerce.springboot.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CartProductRepo extends JpaRepository<CartProduct, Long> {
}
