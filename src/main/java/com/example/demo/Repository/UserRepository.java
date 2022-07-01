package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.mailId=?1")
	public User findByMail(String mail);
	@Query("select u from User u where u.password=?1")
	public User findByPassword(String pwd);
}
