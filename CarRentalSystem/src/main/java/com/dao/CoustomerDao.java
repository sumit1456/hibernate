package com.dao;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.Car;
import com.Coustomer;
import com.util.GetConnection;

public class CoustomerDao {
	static Scanner scan = new Scanner(System.in);
	
	
	public static void takeInputs() {
		System.out.println("Enter the Coustomner name -");
		String name = scan.next();
		
		System.out.println("Enter the Rent Charge -");
		double rent = scan.nextDouble();
		
		System.out.println("Enter the start date");
		System.out.println("yyyy-mm-dd");
		String date = scan.next();
		LocalDate d = LocalDate.parse(date);
		System.out.println("Enter the end date");
		System.out.println("yyyy-mm-dd");
		String e_date = scan.next();
		LocalDate e = LocalDate.parse(e_date);
		
		addCoustomer(name, rent, d, e);
		System.out.println("Coustomer has been added");
		
	}
	
	public static void addCoustomer(String name, double rent, LocalDate startDate, LocalDate endDate) {
		EntityManager em = GetConnection.creatConn();
		Coustomer c = new Coustomer(name, rent, startDate, endDate);
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	
	public static void allocateCar() {
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the coustomer id");
		int id = scan.nextInt();
		try {
			Coustomer cus = em.find(Coustomer.class, id);
            
			if(cus==null) {
				System.out.println("Coustomer id does not exist");
				return;
			}
		    System.out.println("Enter the Car id");
		    int car_id = scan.nextInt();
		    Car car = em.find(Car.class, car_id);
		    
		    em.getTransaction().begin();
		    cus.setC(car);
		    System.out.println("Allocation has been made");
		    em.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println("Problem in finding cus");
			
		}   
		
	}
	
	
	public static void deallocateCar() {
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the coustomer id");
		int id = scan.nextInt();
		try {
			Coustomer cus = em.find(Coustomer.class, id);
			if(cus==null) {
				System.out.println("Coustomer id does not exist");
				return;
			}
		    em.getTransaction().begin();
		    cus.setC(null);
		    System.out.println("Deallocation has been made");
		    em.getTransaction().commit();
		}
		catch(Exception e){
			System.out.println("Problem in finding cus");
			
		}   
		
	}
	
	public static void viewAllCoustomers() {
		EntityManager em = GetConnection.creatConn();
		String hbl = "select c from Coustomer c";
		Query q = em.createQuery(hbl);
		java.util.List<Coustomer> li = q.getResultList();
		li.forEach(al->System.out.println(al));
		
	}
	
	

}
