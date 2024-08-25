package com.springdemo.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WppRepository extends JpaRepository<Whatsapp, UUID> {

}
