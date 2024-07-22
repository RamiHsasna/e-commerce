package com.ecommerce.springboot.repo;

import com.ecommerce.springboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
