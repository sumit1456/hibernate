package com.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.CarDetails;
import com.util.GetConnection;

public class CarDetailsDao {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void takeIpCarDetails() {
		 System.out.println("Enter the Car Model");
		 String model = sc.next();
		 
		 System.out.println("Enter the Engine Type");
		 String etype = sc.next();
		 
		 System.out.println("Enter the seat no");
		 int seats = sc.nextInt();
		 
		 System.out.println("Enter the safety rating");
		 int rating = sc.nextInt();
		 
		 CarDetails cd = new CarDetails(model, etype, seats, rating);
		 addDetails(cd);
		 
	}
	
	public static void addDetails(CarDetails cd) {
		EntityManager em = GetConnection.creatConn();
		
		em.getTransaction().begin();
		em.persist(cd);
		em.getTransaction().commit();
		System.out.println("Car details have been added");
	}

	public static void updateCarDetails() {
		
		
		// TODO Auto-generated method stub
		 EntityManager em = GetConnection.creatConn();
	
		 
		 System.out.println("Enter the car details id ");
		 int c_id = sc.nextInt();
		 CarDetails cd = em.find(CarDetails.class, c_id);
		 
		 if(cd==null) {
			 System.out.println("Car Details Id does not matching");
			 return;
		 }
		 
		 System.out.println("Enter the updated details");
		 System.out.println("Enter the Car Model");
		 String model = sc.next();
		 
		 System.out.println("Enter the Engine Type");
		 String etype = sc.next();
		 
		 System.out.println("Enter the seat no");
		 int seats = sc.nextInt();
		 
		 System.out.println("Enter the safety rating");
		 int rating = sc.nextInt();
		 cd.setModel(model);
		 cd.setSafetyRating(rating);
		 cd.setEngineType(etype);
		 cd.setSeats(seats);
		 em.getTransaction().begin();
		 em.merge(cd);
		 em.getTransaction().commit();
		 
		 System.out.println("Car details have been updated");
		  
		 
		 
		
	}

	public static void deleteCarDetails() {
		EntityManager em = GetConnection.creatConn();
		// TODO Auto-generated method stub
		System.out.println("Enter the Car details id");
		int cd_id = sc.nextInt();
		
		CarDetails cd = em.find(CarDetails.class, cd_id);
		if(cd==null) {
			System.out.println("Car details id does not exist");
			return;
		}
		em.getTransaction().begin();
		em.remove(cd);
		em.getTransaction().commit();
		System.out.println("Car Details have been removed");
	}
	
	

}
