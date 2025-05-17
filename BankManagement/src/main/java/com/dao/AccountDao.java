package com.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.etity.Account;
import com.etity.Coustomer;
import com.util.GetConnection;

public class AccountDao {

	static Scanner s = new Scanner(System.in);
	
	public static Account takeInputs() {
		
		System.out.println("Allocate the account number");
		int acc_no = s.nextInt();
		
		System.out.println("Enter the Balance");
		double balance = s.nextDouble();
		
		System.out.println("Enter the Credit Score");
		double c_score = s.nextDouble();
		
		Account a = new Account(acc_no, balance, c_score);
		return a;
	}
	
	
	
	public static void findAcc() {
		System.out.println("Allocate the account number");
		int acc_no = s.nextInt();
		EntityManager em = GetConnection.creatConn();
		
		Account acc = em.find(Account.class, acc_no);
		System.out.println(acc);
	}
	
	public static void updateBalance() {
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the coustomer id");
		int c_id = s.nextInt();
		Coustomer cus = em.find(Coustomer.class, c_id);
		if(cus==null) {
			System.out.println("Customer does not exist");
			return;
		}
		System.out.println("Enter the Account id");
		int acc_id = s.nextInt();
		
		Account acc = em.find(Account.class, acc_id);
		
		System.out.println("Add or withdraw ?");
		System.out.println("Press 1 to add");
		System.out.println("Press 2 to withdraw");
		
	
		int opt = s.nextInt();
		em.getTransaction().begin();
		if(opt==1) {
			System.out.println("How much amount you want to add");
			double amt = s.nextDouble();
		
			acc.setBalance(acc.getBalance()+amt);
			em.getTransaction().commit();
			System.out.println("The new Account Balance is "+acc.getBalance());
			
		}
		else if(opt==2) {
			System.out.println("How much amount you want to withdraw");
			double amt = s.nextDouble();
		
			acc.setBalance(acc.getBalance()-amt);
			em.getTransaction().commit();
			System.out.println("The new Account Balance is "+acc.getBalance());
		}
		else {
			System.out.println("Please select valid option");
		}
	}
	
}
