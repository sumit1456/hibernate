package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY, generator = "deptno")
    @SequenceGenerator(name = "deptno", initialValue=200, allocationSize = 1)
	private int deptno;
	private String dname;
	
	 
	 public Department() {
		 
	 }

	public Department(String dname) {
		super();
		this.dname = dname;
	}
	
	public String toString() {
		System.out.println("Department id :"+deptno);
		System.out.println("Department name :"+dname);
		return "";
	}
	
}
