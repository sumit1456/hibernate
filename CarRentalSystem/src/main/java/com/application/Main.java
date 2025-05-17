package com.application;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.Coustomer;
import com.dao.CarDao;
import com.dao.CarDetailsDao;
import com.dao.CoustomerDao;
import com.util.GetConnection;

public class Main {
	
    public static void main(String[] args) {
		System.out.println("Welcome to Car Rental System");
		Scanner scan = new Scanner(System.in);
		EntityManager em = GetConnection.creatConn();
		System.out.println("Press 1 to Manage Coustomers");
		System.out.println("Press 2 to Manage Cars");
		System.out.println("Press 3 to Manage CarDetails");
		
		int opt = scan.nextInt();
		
		if(opt==1) {
			System.out.println("Coustomer -");
			System.out.println("Press 1 to add Coustomer");
			System.out.println("Press 2 to delete Coustomer");
			System.out.println("Press 3 to allocate car to coustomer");
			System.out.println("Press 4 to dellocate car from coustomer");
			System.out.println("Press 5 to View all Coustomers");
			
			int opt2 = scan.nextInt();
			
			switch(opt2) {
			
			case 1:{
				CoustomerDao.takeInputs();
				break;
			}
			
			case 3:{
				CoustomerDao.allocateCar();
				break;
			}
			case 4:{
				CoustomerDao.deallocateCar();
				break;
			}
			
			case 5:{
				CoustomerDao.viewAllCoustomers();
				break;
			}

			
			
			}
		}
		else if(opt==2) {
			System.out.println("Cars -");
			System.out.println("Press 1 to view All cars");
			System.out.println("Press 2 to add car");
			System.out.println("Press 3 to Allocate Car Details");
			System.out.println("Press 4 to Remove Car");
			
			
			int opt3 = scan.nextInt();
			
			switch(opt3) {
			
			case 2:{
				CarDao.addCarInputs();
				break;
			}
			case 1:{
				CarDao.viewAllCars();
				break;
			}
			case 3:{
				CarDao.matchDetails();
				break;
			}
			case 4:{
				CarDao.removeCar();
				break;
			}
			
						}
		}
		else if(opt==3) {
			System.out.println("Car Details -");
			System.out.println("Press 1 to add car Details");
			System.out.println("Press 2 to update car Details");
			System.out.println("Press 3 to delete car details");
			
			int opt4 = scan.nextInt();
			
			switch(opt4) {
			case 1:{
				CarDetailsDao.takeIpCarDetails();
				break;
			}
			case 2:{
				CarDetailsDao.updateCarDetails();
				break;
			}
			case 3:{
				CarDetailsDao.deleteCarDetails();
				break;
			}
			
			}
			
		}
	}

}
