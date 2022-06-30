package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Shoe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String shoeComp;
	private String category;
	private int size;
	private int price;
}
