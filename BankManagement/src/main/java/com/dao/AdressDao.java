package com.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.etity.Address;
import com.etity.Coustomer;
import com.util.GetConnection;

public class AdressDao {

	
	
	static Scanner s = new Scanner(System.in);
	
	public static Address fillAddress() {
		EntityManager em = GetConnection.creatConn();
		
		
		System.out.println("Enter the pin code");
		int pin = s.nextInt();
		
		System.out.println("Enter the State");
		String state = s.next();
		
		System.out.println("Enter the city name");
		String city = s.next();
		
		System.out.println("Permanant/Temporary ?");
		String type = s.next();
		
		Address ad = new Address(pin, state, city, type);
		return ad;
		
	}
	
	
	
	//Below method takes only address and returns object ref



}
