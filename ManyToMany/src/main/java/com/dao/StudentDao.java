package com.dao;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.entity.Student;
import com.entity.Subject;
import com.util.GetConnection;

public class StudentDao {


	static Scanner scan = new Scanner(System.in);
	
	
	public static int tkId() {
		System.out.println("Enter the Id of Student");
		int id = scan.nextInt();
		return id;
	}
	
	
	public static String tkName() {
		System.out.println("Enter the Student name");
		String name = scan.next();
		return name;
	}
	

	public static int tkAge() {
		System.out.println("Enter the Student age");
		int age = scan.nextInt();
		return age;
	}
	
	public static void addStudent() {
		EntityManager em = GetConnection.creatConn();
		String student = tkName();
		int n = tkAge();
		
		Student stundent = new Student(student, n);
		em.getTransaction().begin();
		em.persist(stundent);
		em.getTransaction().commit();
	}
	
	public static void removeStudent() {
		EntityManager em = GetConnection.creatConn();
		em.getTransaction().begin();
		em.remove(em.find(Student.class, tkId()));
		em.getTransaction().commit();
		System.out.println("student has been removed");
		
	}
}
