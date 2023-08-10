package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Category;

public interface CategoryDAO extends JpaRepository<Category,String>{
    
}
