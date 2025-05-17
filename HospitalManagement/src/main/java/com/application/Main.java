package com.application;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.dao.BranchDao;
import com.dao.HospitalDao;
import com.util.GetConnection;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("Press 1 to Manage Hospital");
		System.out.println("Press 2 to Manage Branch");
		
		Scanner s = new Scanner(System.in);
     	int opt = s.nextInt();
		
		
		if(opt==1) {
			System.out.println("Hospital -");
			System.out.println("Press 1 to add Hospital");
			int opt2 = s.nextInt();
			switch(opt2) {
			case 1:{
				HospitalDao.addHospital();
				break;
			}
			
			}
		}
		else if(opt==2) {
			System.out.println("Welcome to Branch");
			System.out.println("Press 1 to Add Branch");
			
			int opt3 = s.nextInt();
			
			switch(opt3) {
			
			case 1:{
				BranchDao.addBranch();
				break;
			}
			
			}
		}
		
		
	}
}
