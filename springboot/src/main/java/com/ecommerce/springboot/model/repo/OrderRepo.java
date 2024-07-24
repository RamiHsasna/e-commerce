package com.ecommerce.springboot.model.repo;
import com.ecommerce.springboot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepo extends JpaRepository<Order, Long> {
}
