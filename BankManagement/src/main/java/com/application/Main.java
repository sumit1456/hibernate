package com.application;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.dao.AccountDao;
import com.dao.BankDao;
import com.dao.CoustomerDao;
import com.util.GetConnection;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Press 1 to Manage Bank");
		System.out.println("Press 2 to Manage Coustomer");
		System.out.println("Press 3 to Manage Account");
		System.out.println("Press 4 to Manage Coustomer Address Details");
		int opt1 = s.nextInt();
		
		if(opt1==1) {
			System.out.println("Manage the Bank");
			System.out.println("Press 1 to add Bank");
			System.out.println("Press 2 to find bank by name");
			
			
			int opt2 = s.nextInt();
			
			switch(opt2) {
			
			case 1:{
				BankDao.takeInputs();
				break;
			}
			
			case 2:{
				BankDao.findByName();
			}
			
			}
		}
		else if(opt1==2) {
			System.out.println("Coustomer -");
			System.out.println("Press 1 to add Coustomer");
			System.out.println("Press 3 to add Coustomer with address");
			
			int opt3 = s.nextInt();
			switch(opt3) {
			
			case 1:{
				CoustomerDao.takeInputs();
				break;
			}
			
			case 2:{
				
			}
			
			}
		}
		else if(opt1==3) {
			System.out.println("Account -");
			System.out.println("Press 1 to view Account Details");
			System.out.println("Press 2 to Update Account");
			
			int opt4 = s.nextInt();
			
			switch(opt4) {
			case 1:{
				AccountDao.findAcc();
				break;
			}
			case 2:{
				AccountDao.updateBalance();
				break;
			}
			}
			
		}
		
	}

}
