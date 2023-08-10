package com.springboot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.AccountDAO;
import com.springboot.model.Account;

@RestController
@RequestMapping(value = "/api")
public class AccountRestController {

    @Autowired
    AccountDAO accountDAO;

    @GetMapping(value = "/accounts")
    private ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.ok(accountDAO.findAll());
    }

    @GetMapping(value = "/account/{username}")
    private ResponseEntity<Account> getOne(@PathVariable("username") String username){
        if(!accountDAO.existsById(username)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountDAO.findById(username).get());
    }

    @PostMapping(value = "/account")
    private ResponseEntity<Account> create(@RequestBody Account account){
        if(accountDAO.existsById(account.getUsername())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(accountDAO.save(account));
    }

    @PutMapping(value = "/account/{username}")
    private ResponseEntity<Account> update(@PathVariable("username") String username,@RequestBody Account account){
        if(!accountDAO.existsById(username)){
            return ResponseEntity.notFound().build();
        }
         return ResponseEntity.ok(accountDAO.save(account)); 
    }

    @DeleteMapping(value = "/account/{username}")
    private ResponseEntity<Void> delete(@PathVariable("username") String username){
         if(!accountDAO.existsById(username)){
            return ResponseEntity.notFound().build();
        }
        accountDAO.deleteById(username);
        return ResponseEntity.ok().build(); 
    }
}
