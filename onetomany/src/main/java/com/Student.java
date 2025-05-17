package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Student {
	
	@Id
	@GeneratedValue(generator = "s_id", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "s_id", initialValue = 1, allocationSize = 1)
	private int s_id;
	private String name;
	private int age;
	
	public String toString() {
		System.out.println("sid "+ s_id);
		System.out.println("Student Name :"+name);
		System.out.println("Student age :"+age);
		return "";
	}

}
