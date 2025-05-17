package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.etity.Account;
import com.etity.Address;
import com.etity.Bank;
import com.etity.Coustomer;
import com.util.GetConnection;

public class CoustomerDao {
	
	static Scanner s = new Scanner(System.in);
	
	public static void takeInputs() {
		
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the bank id");
		int id = s.nextInt();
		Bank b = em.find(Bank.class, id);
		
		List<Coustomer> coustomer_list = b.getCous();
		System.out.println("Enter the Coustomer Name");
		String name = s.next();
		
		System.out.println("Enter the Date of Birth");
		String bdate = s.next();
		
		System.out.println("Enter the Phone no");
		String no = s.next();
		
		Coustomer c = new Coustomer(name, bdate, no);
		
		Account acc = AccountDao.takeInputs();
		c.setAcc_id(acc);
		Address ad = AdressDao.fillAddress();
		List<Address> li = c.getAddress();
		
		li.add(ad);
		coustomer_list.add(c);
		
		em.getTransaction().begin();
		em.persist(acc);
		em.persist(ad);
		em.persist(c);
		em.getTransaction().commit();
		System.out.println("Coustomer has been added");
		
	}
	
	


}
