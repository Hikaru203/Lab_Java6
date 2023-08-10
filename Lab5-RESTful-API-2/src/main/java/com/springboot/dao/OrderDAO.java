package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Order;

public interface OrderDAO extends JpaRepository<Order,Long>{
    
}
