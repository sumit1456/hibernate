package com.entity;

import java.time.LocalDate;

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
public class Patient {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "p_id")
	@SequenceGenerator(name = "p_id", initialValue=1000, allocationSize=1)
	private long p_id;
	private String name;
	private LocalDate dob;
	private String med_history;
}
