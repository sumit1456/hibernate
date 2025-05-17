package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "id")
    @SequenceGenerator(name = "id", initialValue=1, allocationSize = 1)
	private int id;
    private String name;
    private double salary;
    
    @ManyToOne
    @JoinColumn(name = "deptno")
    private Department deptno;
    
    
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public Employee() {
		
	}
	
	public String toString() {
		System.out.println("Employee Name :"+name);
		System.out.println("Employee Salary :"+salary);
		System.out.println(deptno);
		return "";
	}
    
   
    
}
