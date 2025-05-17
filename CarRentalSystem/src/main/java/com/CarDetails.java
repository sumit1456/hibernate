package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class CarDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cd_no")
	@SequenceGenerator(name = "cd_no", initialValue = 1001, allocationSize=1)
	private int cd_no;
	private String model;
	private String engineType;
	private int seats;
	private int safetyRating;
	
	
	
	public CarDetails(int cd_no, String model, String engineType, int seats, int safetyRating) {
		super();
		this.cd_no = cd_no;
		this.model = model;
		this.engineType = engineType;
		this.seats = seats;
		this.safetyRating = safetyRating;
	}
	
	public CarDetails(String model, String engineType, int seats, int rating) {
		this.model = model;
		this.engineType = engineType;
		this.seats = seats;
		this.safetyRating = rating;
	}
	
	public CarDetails() {
		
	}
	
}
