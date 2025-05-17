package com.dao;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entity.Student;
import com.entity.Subject;
import com.util.GetConnection;

public class SubjectDao {
	
	
	static Scanner scan = new Scanner(System.in);
	

	public static int tkId() {
		System.out.println("Enter the Subject Id");
		int id = scan.nextInt();
		return id;
	}
	
	public static String tkSubject() {
		System.out.println("Enter the Subject name");
		String name = scan.next();
		return name;
	}
	

	public static int tkNo() {
		System.out.println("Enter the Subject Duration");
		int no = scan.nextInt();
		return no;
	}
	
	public static void addSubject() {
		EntityManager em = GetConnection.creatConn();
		String s = tkSubject();
		int n = tkNo();
		Subject sub = new Subject(s, n);
		em.getTransaction().begin();
		em.persist(sub);
		em.getTransaction().commit();
	}
	
	public static Subject getSubject(int id) {
		EntityManager em = GetConnection.creatConn();
		em.getTransaction().begin();
		Subject sub = em.find(Subject.class, id);
		return sub;
		
	}
	
	
	public static void addSubjects() {
		EntityManager em = GetConnection.creatConn();
		Student s = em.find(Student.class, tkId());
	
		System.out.println("Press 1 to Start adding subjects");
		System.out.println("Press 2 to stop adding Subjects");
		
		int opt = scan.nextInt();
		
		while(opt!=2) {
            em.getTransaction().begin();
			Subject subject = SubjectDao.getSubject(SubjectDao.tkId());
			s.getSubjects().add(subject);
			em.getTransaction().commit();
			System.out.println("Press 1 to continue or 2 to exist");
			opt = scan.nextInt();
			
		}
		em.close();
		
		System.out.println("Subjects has been added to Student");
		
		
	}
	
	
	
	public static void removeSubject() {
		EntityManager em = GetConnection.creatConn();
		Student student = em.find(Student.class, tkId());
		ArrayList<Integer> al = new ArrayList <>();
		System.out.println("Press 1 to start");
		int opt = scan.nextInt();
		
		while(opt!=2) {
			System.out.println("Enter the Subject Code");
			al.add(scan.nextInt());
			System.out.println("Press 1 to Continue 2 to Exist");
			opt = scan.nextInt();
		}
		em.getTransaction().begin();
		al.forEach(id->student.getSubjects().remove(id));
		em.merge(student);
		em.getTransaction().commit();
		
	}
	
	public static void removeSubUpdated() {
		EntityManager em = GetConnection.creatConn();
		Student student = em.find(Student.class, tkId());
		System.out.println("Press 1 to start");
		int opt = scan.nextInt();
		em.getTransaction().begin();
		while(opt!=2) {
			System.out.println("Enter the Subject Code");
			opt = scan.nextInt();
			student.getSubjects().remove(em.find(Subject.class, tkId()));
			System.out.println("Press 1 to Continue 2 to Exist");
			opt=scan.nextInt();
		}
		em.merge(student);
		em.getTransaction().commit();
	}
	
	public static void removeSingleSubject() {
		EntityManager em = GetConnection.creatConn();
		Student student = em.find(Student.class, tkId());
		em.getTransaction().begin();
		student.getSubjects().remove(em.find(Subject.class, SubjectDao.tkId()));
		em.getTransaction().commit();
		em.close();
		System.out.println("Subject has been removed");
	}
	

}

