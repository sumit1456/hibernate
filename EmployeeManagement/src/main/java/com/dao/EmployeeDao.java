package com.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entity.Department;
import com.entity.Employee;
import com.util.GetConnection;

public class EmployeeDao {

	EntityManager em = GetConnection.creatConn();
	
	static Scanner sc = new Scanner(System.in);
	public static void takeInputs() {
		
		System.out.println("Enter the Employee name");
		String name = sc.next();
		
		System.out.println("Enter the salary of Employee");
		double sal = sc.nextDouble();
		
		Employee e = new Employee(name, sal);
		
		addEmpToDb(e);
		System.out.println("Employee has been added");
	
	}
	
	public static void addEmpToDb(Employee e) {
		EntityManager em = GetConnection.creatConn();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
		
	
	}
	
	public static void allocateDept() {
		EntityManager em = GetConnection.creatConn();
		try {
			
			System.out.println("Enter the DepartMent no");
			int dept_no = sc.nextInt();
			Department dept = em.find(Department.class, dept_no);
			DeptDao.checkEmpty(dept);
			System.out.println("Enter the Employee id");
			int eid = sc.nextInt();
			
			Employee e = em.find(Employee.class, eid);
			DeptDao.checkEmpty(e);
			
			e.setDeptno(dept);
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
			System.out.println("Department has been allocated to Employee");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
		}
		
	
	
	public static void deAllocateDept() {
		EntityManager em = GetConnection.creatConn();
		try {
			
			System.out.println("Enter the DepartMent no");
			int dept_no = sc.nextInt();
			Department dept = em.find(Department.class, dept_no);
			DeptDao.checkEmpty(dept);
			
			System.out.println("Enter the Employee id");
			int eid = sc.nextInt();
			
			Employee e = em.find(Employee.class, eid);
			DeptDao.checkEmpty(e);
			e.setDeptno(null);
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
			System.out.println("Department has been Deallocated from Employee");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
		
		
	}
	
	
	public static void deleteEmployee() {
		
		try {
			System.out.println("Enter the DepartMent no");
			int dept_no = sc.nextInt();
			
			System.out.println("Enter the Employee id");
			int eid = sc.nextInt();
			EntityManager em = GetConnection.creatConn();
	        Department dept = em.find(Department.class, dept_no);
	    	DeptDao.checkEmpty(dept);
			Employee e = em.find(Employee.class, eid);
			DeptDao.checkEmpty(e);
			e.setDeptno(null);
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			System.out.println("Employee has been deleted");
			em.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public static void deAllocateOnDept() {
		EntityManager em = GetConnection.creatConn();	
		int deptno = tkDeptIp();
		Department dept = em.find(Department.class, deptno);
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("update Employee e set e.deptno=null where e.deptno=?1");
			q.setParameter(1, dept);
			q.executeUpdate();
			em.getTransaction().commit();
			
			System.out.println("Employees has been deallocated deptno");
		}
		catch(Exception e) {
			
		}
		finally {
			em.close();
		}
		
		

	}
	
	public static int tkDeptIp() {
		System.out.println("Enter the Dept no of Employee");
		int deptno = sc.nextInt();
		return deptno;
	}
	
	public static void viewByDept() {
		EntityManager em = GetConnection.creatConn();	

		int deptno = tkDeptIp();
		
		String query = "select * from employee where deptno=?";
		Query q = em.createNativeQuery(query, Employee.class);
		q.setParameter(1, deptno);
		
		List<Employee> li = q.getResultList();
		li.forEach(al->System.out.println(al));
	}
	
	public static void viewAll() {
		EntityManager em = GetConnection.creatConn();	
		String query ="select s from Employee s ";
		Query q = em.createQuery(query);
		List<Employee> li = q.getResultList();
		li.forEach(al->System.out.println(al));
	}
}
