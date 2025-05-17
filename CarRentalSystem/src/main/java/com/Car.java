package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Car {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "car_id")
	@SequenceGenerator(name = "car_id", initialValue=100, allocationSize=1)
	private int car_id;
	private String brand;
	private String type;
	@OneToOne
	private CarDetails c;
	
	public Car(String brand, String type) {
		super();
		this.brand = brand;
		this.type = type;
		this.c = null;
	}
	
	public Car() {
		
	}

}
