package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AdminRepository;
import com.example.demo.entity.Admin;

@Service
public class AdminDao {
	@Autowired
	AdminRepository arepo;
	
	public Admin insert(Admin a) {
		return arepo.save(a);
	}
	public Admin byEmail(String mail) {
		return arepo.findByMail(mail);
	}
	
	public Admin byPassword(String pwd) {
		return arepo.findByPassword(pwd);
	}

}
