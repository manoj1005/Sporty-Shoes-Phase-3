package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;

@Service
public class UserDao {
	@Autowired
	UserRepository urepo;
	//Register the user data
	public User insert(User u) {
		return urepo.save(u);
	}
	
	//Retrieve all users
	public List<User> retrieve(){
		return urepo.findAll();
	}
	
	//Find User through Mail Id
	public User getUserByMail(String mail) {
		return urepo.findByMail(mail);
	}
	
	//Find User trough Password
	public User getUserByPassword(String pwd) {
		return urepo.findByPassword(pwd);
	}
	
	//Update Password
	public User update(String mail,String pwd) {
		User u=urepo.findByMail(mail);
		u.setPassword(pwd);
		return urepo.save(u);
	}
	
	//update User Details
	public User adminUpdatesuser(User user) {
		User u=urepo.findById(user.getId()).orElse(null);
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setMailId(user.getMailId());
		u.setPassword(user.getPassword());
		return urepo.save(u);
	}
	
	//Delete User
	public String deleteUser(int id) {
		urepo.deleteById(id);
		return "Deleted User Details";
	}
}
