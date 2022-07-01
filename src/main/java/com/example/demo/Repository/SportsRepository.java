package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Sports;

public interface SportsRepository extends JpaRepository<Sports,Integer>{

}
