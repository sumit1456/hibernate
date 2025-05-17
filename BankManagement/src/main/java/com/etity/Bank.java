package com.etity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Data
public class Bank {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY, generator="id")
	@SequenceGenerator(name = "id", initialValue=1, allocationSize=1)
	private int id;
	private String name;
	private String location;
	private String branch;
	
	@OneToMany
	List<Coustomer> cous;
	
	
	
	public Bank() {
		
	}

	public Bank(String name, String location, String branch) {
		this.name = name;
		this.location = location;
		this.branch = branch;
		this.cous = new <Coustomer> ArrayList();
		
	}
	
	public String toString() {
		System.out.println("==========================");
		System.out.println("Bank name -"+name);
		System.out.println("Bank branch "+branch);
		System.out.println("Bank Loaction "+location);
		return "";
		
	}
	
	
}
