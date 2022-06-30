package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
}
