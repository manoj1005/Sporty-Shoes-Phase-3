package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

}
