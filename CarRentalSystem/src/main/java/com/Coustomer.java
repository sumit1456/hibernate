package com;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Coustomer {
	
	
	public Coustomer() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="car_id")
	private int id;
	private String name;
	private double amount;
	@OneToOne
	private Car c ;
	private LocalDate endDate;
	private LocalDate startDate;
	
	public Coustomer(String name, double amount,LocalDate startDate, LocalDate endDate) {
		super();
		this.name = name;
		this.amount = amount;
		this.c = null;
		this.endDate = endDate;
		this.startDate = startDate;
	}
	
	public String toString() {
		System.out.println("Coustomer Id :"+id);
		System.out.println("Coustomer Name :"+name);
		System.out.println("Rent Amount :"+amount);
		System.out.println("Starting date: "+startDate);
		System.out.println("Ending date "+endDate);
		System.out.println("=======================================");
		return "";
	}

}
