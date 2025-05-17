package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.util.GetConnection;

import lombok.Data;

@Entity
@Data
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "b_id")
	@SequenceGenerator(name = "b_id", initialValue=100, allocationSize=1)
	private long b_id;
	private String loc;
	private String phoneno;
	
	@OneToMany
	private List<Patient> p;

	public Branch(String loc, String phoneno) {
		super();
		this.loc = loc;
		this.phoneno = phoneno;
		this.p = new ArrayList();
	}
	
	


}

