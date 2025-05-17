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
public class Student {

	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "i")
	@SequenceGenerator(name = "i", initialValue=1000, allocationSize=1)
	@Column(name = "Student_id")
	private int s_id;
	private String name;
	
	public Student(String s, int age) {
		super();
		this.name = s;
		this.age = age;
		
	}
	
	public Student() {
		
	}


	private int age;
	
	
	@ManyToMany
	private List<Subject> subjects = new ArrayList<>();
	
}
