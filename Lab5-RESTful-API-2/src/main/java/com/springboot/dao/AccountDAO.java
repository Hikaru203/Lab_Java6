package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Account;

public interface AccountDAO extends JpaRepository<Account,String> {
    
}
