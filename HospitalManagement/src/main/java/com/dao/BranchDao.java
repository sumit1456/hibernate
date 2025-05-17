package com.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.entity.Branch;
import com.entity.Hospital;
import com.util.GetConnection;

public class BranchDao {

	static Scanner s = new Scanner(System.in);
	public static void addBranch() {
		
		EntityManager em = GetConnection.creatConn();
		
		System.out.println("Enter the Hospital Id");
		long h_id = s.nextLong();
		
		Hospital h = em.find(Hospital.class, h_id);
		List<Branch> li = h.getBranches();
		
		System.out.println("Enter the Location of Branch");
		String loc = s.nextLine();
		
		System.out.println("Enter the phone no");
		String no = s.next();
		
		Branch b = new Branch(loc, no);
		
		em.getTransaction().begin();
	    li.add(b);
		System.out.println("Branch has been added");
	}
}
