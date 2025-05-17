package com.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entity.Department;
import com.entity.Employee;
import com.exception.EmptyListException;
import com.exception.InvalidIdException;
import com.util.GetConnection;

public class DeptDao {

	
	static Scanner sc = new Scanner(System.in);
	public static void takeInputs() {
		System.out.println("Enter the Department name");
		String name = sc.next();
		Department dept = new Department(name);
		addDept(dept);
		System.out.println("Department has been added");
	}
	
	public static void addDept(Department dept) {
		EntityManager em = GetConnection.creatConn();
		em.getTransaction().begin();
		em.persist(dept);
		em.getTransaction().commit();
	}
	
	public static void deleteDept() {
		try {
			EntityManager em = GetConnection.creatConn();
			System.out.println("Enter the Dpet no");
			int dept_no = sc.nextInt();
			Department dept = em.find(Department.class, dept_no);
			checkEmpty(dept);
			em.getTransaction().begin();
			Query q = em.createQuery("Update Employee e set e.deptno = null where e.deptno=:dept");
			q.setParameter("dept", dept);
			q.executeUpdate();
			em.remove(dept);
			em.getTransaction().commit();
			
			System.out.println("Department has been deleted");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static <T> void checkEmpty( T ob) {
		if(ob==null) {
			System.out.println("Invalid id");
			throw new InvalidIdException();
		}
	}
	
	public static void viewAllDepartments() {
		EntityManager em = GetConnection.creatConn();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select d from employee d");
			List<Department> dept = q.getResultList();
			checkList(dept);
			dept.forEach(al->System.out.println(al));
			em.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
		
	}
	
	public static void checkList(List l) {
		if(l.isEmpty()||l==null) {
			throw new EmptyListException();
		}
	}
}
