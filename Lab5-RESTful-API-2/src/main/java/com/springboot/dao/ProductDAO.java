package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Product;

public interface ProductDAO  extends JpaRepository<Product,Integer>{
    
}
