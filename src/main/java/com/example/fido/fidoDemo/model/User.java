package com.example.fido.fidoDemo.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private byte[] publicKey;
    private String credentialId;
    private long counter;

    // Getters and Setters
}

