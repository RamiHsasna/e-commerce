package com.ecommerce.springboot.model.repo;

import com.ecommerce.springboot.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}
