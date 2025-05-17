package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Subject {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "s")
	@SequenceGenerator(name = "s", initialValue=1, allocationSize=1)
	@Column(name = "Subject_code")
	private int id;
	private String name;
	private int no_of_day;
	
	
	
	
	
	public Subject(String name, int no_of_day) {
		super();
		this.name = name;
		this.no_of_day = no_of_day;
	}
	
	public Subject() {
		
	}
	
	public String toString() {
		System.out.println("Subject Name -"+name);
		System.out.println("Duration -"+no_of_day);
		return "";
	}
	
}
