package com.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.Car;
import com.CarDetails;
import com.Coustomer;
import com.util.GetConnection;

import antlr.collections.List;

public class CarDao {
	
static Scanner scan = new Scanner(System.in);
	
	
	public static void addCarInputs() {
		
		System.out.println("Enter the Brand Name -");
		String brand = scan.next();
		
		System.out.println("Enter the Engine Type -");
		String type = scan.next();
		
		
		addCar(brand, type);
		System.out.println("Coustomer has been added");
		
	}
	
	public static void addCar(String brand, String type) {
		EntityManager em = GetConnection.creatConn();
		Car c = new Car(brand, type);
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	public static void viewAllCars() {
		EntityManager em = GetConnection.creatConn();
		String hbl = "select c from Car c";
		Query q = em.createQuery(hbl);
	    
		java.util.List al = q.getResultList();
		
		al.forEach(car->System.out.println(car));
	}
	
	public static void matchDetails() {
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the car id");
		int c_id = scan.nextInt();
		Car car = em.find(Car.class, c_id);
		if(car==null) {
			System.out.println("Car id is not found");
			return;
		}
		System.out.println("Enter the car Detials Id");
		int cd_id = scan.nextInt();
		CarDetails cd = em.find(CarDetails.class, cd_id);
		if(cd==null) {
			System.out.println("Car details id is not found");
			return;
		}
		em.getTransaction().begin();
		car.setC(cd);
		em.getTransaction().commit();
		System.out.println("Car details have been allocated");
	}
	
	public static void removeCar() {
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the car id");
		int c_id = scan.nextInt();
		Car car = em.find(Car.class, c_id);
		em.getTransaction().begin();
		em.remove(car);
		em.getTransaction().commit();
		System.out.println("Car record has been deleted");
		
		
	}


}
