package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDao {
	@Autowired
	PurchaseRepository prepo;
	
	public Purchase insert(Purchase p) {
		return prepo.save(p);
	}
	
	public List<Purchase> getall(){
		return prepo.findAll();
	}

}
