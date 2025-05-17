package com;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class College {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY, generator = "c_id")
	@SequenceGenerator(initialValue=100, name = "c_id", allocationSize=1)
	private int c_id;
	private String name;
	private String location;
	@OneToMany
	List<Student> student;
	
}
