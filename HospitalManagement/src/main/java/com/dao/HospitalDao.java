package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.entity.Branch;
import com.entity.Hospital;
import com.util.GetConnection;

import Exception.InvalidId;

public class HospitalDao {

	
	static Scanner s = new Scanner(System.in);
	
	public static void addHospital() {
		
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the Hospital Name -");
		String name = s.nextLine();
		System.out.println("Enter the Hospital Address -");
		String add = s.nextLine();
		
		Hospital h = new Hospital(name, add);
		em.getTransaction().begin();
		em.persist(h);
		em.getTransaction().commit();
		
		System.out.println("Hospital has been added");
	}
	
	public static void assignBranch() {
		EntityManager em = GetConnection.creatConn();
		
		long h_id = takeH();
		long b_id = takeB();
		
		Hospital h = em.find(Hospital.class, h_id);
		Branch b = em.find(Branch.class, b_id);
		
		if(h==null || b==null) {
			System.out.println("Hospital or branch id is wrong");
		}
		
		List<Branch> li = new ArrayList<Branch>();
		
		em.getTransaction().begin();
		li.add(b);
		em.merge(h);
		em.getTransaction().commit();
		
		System.out.println("The Branch has been assigned");
		
		
	}
	
	public static  void checker(Hospital h, Branch b) {
		if(h==null || b==null) {
			throw new InvalidId();
		}
	}
	
	public static Long takeH() {
		System.out.println("Enter the Hospital id");
		long h_id = s.nextLong();
		return h_id;
	}
	
	public static Long takeB() {
		System.out.println("Enter the Branch id");
		long b_id = s.nextLong();
		return b_id;
	}
	
	public static void deleteBranch() {
		EntityManager em = GetConnection.creatConn();
		long h_id = takeH();
		long b_id = takeB();
		
		Hospital h = em.find(Hospital.class, h_id);
		Branch b = em.find(Branch.class, b_id);
		
		checker(h, b);
		List<Branch> branches = h.getBranches();
		em.getTransaction().begin();
		
		branches.removeIf(al-> al.getB_id()==b_id);
		System.out.println("Branch has been removed");
	}
}
