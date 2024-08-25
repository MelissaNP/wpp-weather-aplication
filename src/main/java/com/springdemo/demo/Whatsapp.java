package com.springdemo.demo;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
public class Whatsapp implements Serializable {
    
    private UUID idProduct;
    private String phoneNumber;
    
    
    public Whatsapp(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Whatsapp() {
    
    }
    
}
