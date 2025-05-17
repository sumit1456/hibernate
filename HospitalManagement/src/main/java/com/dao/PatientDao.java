package com.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.entity.Branch;
import com.entity.Patient;
import com.util.GetConnection;

public class PatientDao {
	
	static Scanner s = new Scanner(System.in);
	
	public static String tkName() {
		System.out.println("Enter the patient name");
		String name = s.nextLine();
		return name;
	}
	
	public static String tkLoc() {
		System.out.println("Enter the location ");
		String loc = s.nextLine();
		return loc;
	}
	
	public static String tkMedHis() {
		System.out.println("Enter the Medical History of Patient ");
		String med_his = s.nextLine();
		return med_his;
	}
	
	public static int tkBranch() {
		System.out.println("Enter the branch id");
		int id = s.nextInt();
		return id;
	}
	
	public static int tkPatient() {
		System.out.println("Enter the Patient id");
		int id = s.nextInt();
		return id;
	}
	
	
	public static void addPatient() {
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the branch id");
		int b_id = tkBranch();
		String name = tkName();
		String loc = tkLoc();
		String med = tkMedHis();
		
		Patient p = new Patient();
		Branch b = em.find(Branch.class, b_id);
		List<Patient> li = b.getP();
		li.add(p);
		em.getTransaction().begin();
		em.persist(p);
		em.merge(b);
		em.getTransaction().commit();
		System.out.println("Patient has been added");
		em.close();
		
	}
	
	public static void removePatient() {
		EntityManager em = GetConnection.creatConn();
		System.out.println("Enter the branch id");
		int b_id = tkBranch();
		String name = tkName();
		String loc = tkLoc();
		String med = tkMedHis();
		
		Patient p = new Patient();
		Branch b = em.find(Branch.class, b_id);
		List<Patient> li = b.getP();
	    li.removeIf(al->al==p);
		em.getTransaction().begin();
		em.remove(p);
		em.merge(b);
		em.getTransaction().commit();
		System.out.println("Patient has been removed");
		em.close();
		
	}
	
	public static void viewAllPatients() {
		EntityManager em = GetConnection.creatConn();
		int b_id = tkBranch();
		Branch b = em.find(Branch.class, b_id);
		List<Patient> patients = b.getP();
		patients.forEach(al->System.out.println(al));
	}
	
	public static void viewById() {
		int id = tkPatient();
	}

}
