package com.springdemo.demo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "WppNumbers")
@Data
public class Whatsapp implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduct;
    private String phoneNumber;
    
    
    public Whatsapp(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Whatsapp() {
    
    }
    
}
