package com.etity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="a_id")
	@SequenceGenerator(initialValue=51, allocationSize=1, name="a_id")
	private int a_id;
	
	private int pincode;
	private String state;
	private String city;
	private String addressType;
	
	
	public Address(int pincode, String state, String city, String addressType) {
		super();
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.addressType = addressType;
	}
	
	public Address() {
		
	}
}
