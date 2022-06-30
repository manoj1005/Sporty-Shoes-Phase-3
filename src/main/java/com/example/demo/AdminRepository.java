package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	@Query("Select a from Admin a where a.email=?1")
	public Admin findByMail(String mail);
	
	@Query("Select a from Admin a where a.password=?1")
	public Admin findByPassword(String password);

}
