package com.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account implements Serializable{
    @Id
    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Fullname", nullable = false)
    private String fullname;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Photo", nullable = false)
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Order> orders;
}
