package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "h_id")
	@SequenceGenerator(name = "h_id", initialValue=50, allocationSize=1)
	private long h_id;
	private String name;
	private String address;
	
	@OneToMany
	private List<Branch> branches;
	public Hospital(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.branches= new ArrayList();
	}
	
	public Hospital(){
		
	}
	
	

	
}
