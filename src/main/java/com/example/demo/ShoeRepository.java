package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoeRepository extends JpaRepository<Shoe, Integer> {
}
