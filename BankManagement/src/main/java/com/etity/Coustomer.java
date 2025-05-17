package com.etity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Data
public class Coustomer {
	
	@Id
	@GeneratedValue(generator="c_id", strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="c_id", initialValue=1, allocationSize=1)
	private int c_id;
	private String name;
	private String dob;
	private String phone_no;
	
	@OneToOne
	private Account acc_id;
	
	@OneToMany
	List <Address> address;
	
	
	public Coustomer() {
		
	}


	public Coustomer(String name, String dob, String phone_no) {
		super();
		this.name = name;
		this.dob = dob;
		this.phone_no = phone_no;
		this.address = new <Address> ArrayList();
	}
	

}
