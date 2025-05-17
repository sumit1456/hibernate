package com.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.etity.Bank;
import com.util.GetConnection;


public class BankDao {
    static Scanner s = new Scanner(System.in);
	
	public static void addBank(Bank b) {
		EntityManager em = GetConnection.creatConn();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		System.out.println("Bank has been successfully added");
		 
		
	}
	
	public static void takeInputs() {
		System.out.println("Enter the Bank Name");
		String name = s.next();
		
		System.out.println("Enter the Branch name of Bank");
		String bname = s.next();
		
		System.out.println("Enter the Location of Branch");
		String loc = s.next();
		
		Bank bank = new Bank(name, loc, bname);
		
		addBank(bank);
		
	}

	public static void findByName() {
		// TODO Auto-generated method stub
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the Bank name");
		String name = s.next();
		String jbql = "select s from Bank s where s.name=:bname";
		Query q = em.createQuery(jbql);
		q.setParameter("bname", name);
	
		Object li = q.getSingleResult();
		System.out.println(li);
		
	}
}
