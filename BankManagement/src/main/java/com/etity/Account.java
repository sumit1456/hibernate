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
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="acc_id")
	@SequenceGenerator(initialValue=1001, allocationSize=1, name="acc_id")
	private int acc_id;
	private int acc_no;
	private double balance;
	private double credit_score;
	
	public Account(int acc_no, double balance, double credit_score) {
		this.acc_no = acc_no;
		this.balance = balance;
		this.credit_score = credit_score;
	}

	public Account() {
		
	}
	
	
	

}
