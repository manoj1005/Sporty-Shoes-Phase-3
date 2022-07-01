package com.example.demo.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Shoe shoe;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	private int price;
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate=new Date(System.currentTimeMillis());
	
	private String Address;
}
