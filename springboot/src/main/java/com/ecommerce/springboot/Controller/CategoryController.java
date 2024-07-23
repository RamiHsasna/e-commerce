package com.ecommerce.springboot.Controller;

import com.ecommerce.springboot.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.springboot.model.Category;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepo repo;
    @PostMapping("/addCategory")
    public void addCategory(@RequestBody Category category) {
        repo.save(category);
    }

}
