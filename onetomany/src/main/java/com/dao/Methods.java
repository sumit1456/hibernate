package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;

import com.College;
import com.Student;



public class Methods {

	static Scanner sc = new Scanner(System.in);
	
	public static void add() {
		EntityManager em = GetConnection.getConn();
		Student s = new Student();
		Student s2 = new Student();
		s.setName("Smith");
		s.setAge(22);
		
		s2.setName("Allen");
		s2.setAge(19);
		List <Student> al = new ArrayList();
		al.add(s);
		al.add(s2);
		
		
		College c = new College();
		c.setName("C2");
		c.setLocation("L2");
		c.setStudent(al);

		
		em.getTransaction().begin();
		em.persist(s);
		em.persist(s2);
		em.persist(c);
		
		em.getTransaction().commit();
		System.out.println("Sucesss");
		
	}
	
	public static void addStudent() {
		EntityManager em = GetConnection.getConn();
		System.out.println("Enter the Collge id");
		int c_id = sc.nextInt();
		
		System.out.println("Enter the name -");
		String name = sc.next();
		
		System.out.println("Enter the age");
		int age = sc.nextInt();
		Student s = new Student();
		s.setAge(age);
		s.setName(name);
		College c = em.find(College.class, c_id);
		List al = c.getStudent();
		al.add(s);
		
		em.getTransaction().begin();
		em.persist(s);
		em.merge(c);
		em.getTransaction().commit();
		System.out.println("Student has been added");
	}
	
	
	
	public static void viewCollegeStudent() {
		EntityManager em = GetConnection.getConn();
		System.out.println("Enter the college Id");
		int id = sc.nextInt();
		
		College c = em.find(College.class, id);
		
		List li = c.getStudent();
		System.out.println("College Details -");
		li.forEach(al->System.out.println(al));
	}
	
	public static void deleteStudent() {
		EntityManager em = GetConnection.getConn();
		System.out.println("Enter the Student id");
		int id = sc.nextInt();
		System.out.println("Enter the College id");
		int c_id = sc.nextInt();
		
		College c = em.find(College.class, c_id);
		List<Student> li = c.getStudent();
	
		li.removeIf(al->al.getS_id()==id);
		
		Student s = em.find(Student.class, id);
		
		em.getTransaction().begin();
		c.setStudent(li);
		em.merge(c);
		em.remove(s);
		
		em.getTransaction().commit();
		System.out.println("Student has been deleted");
		em.close();
		
	}
	
	public static void deleteCollege() {
		EntityManager em = GetConnection.getConn();
		System.out.println("Enter the collge id");
		int c_id = sc.nextInt();
		College c = em.find(College.class, c_id);
		
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		System.out.println("College has been removed");
	}
	
	
	
	
	
}
