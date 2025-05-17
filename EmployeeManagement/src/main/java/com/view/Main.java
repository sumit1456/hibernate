package com.view;

import java.util.Scanner;

import com.dao.DeptDao;
import com.dao.EmployeeDao;

public class Main {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press 1 to Manage Department");
		System.out.println("Press 2 to manage Employee");
		
		
		int opt = sc.nextInt();
		
		if(opt==1) {
			System.out.println("Press 1 to add Department");
			System.out.println("Press 2 to remove Department");
			System.out.println("Press 3 to view All Departments");
			
			int opt3 = sc.nextInt();
			
			switch(opt3) {
			case 1:{
				DeptDao.takeInputs();
				break;
			}
			
			case 2:{
				DeptDao.deleteDept();
				break;
			}
			case 3:{
				DeptDao.viewAllDepartments();
				break;
			}
			}
		}
		
		else if(opt==2) {
			
			System.out.println("Press 1 to Add Employee");
			System.out.println("Press 2 to Allocate Department to Employee");
			System.out.println("Press 3 to Deallocate Department from Employee");
			System.out.println("Press 4 to Dellocate to All Employee based on id");
			System.out.println("Press 5 to View Employee based on Department no");
			System.out.println("Press 6 to view All Employees");
			
			int opt4 = sc.nextInt();
			
			switch(opt4) {
			
			case 1:{
				EmployeeDao.takeInputs();
				break;
			}
			case 2:{
				EmployeeDao.allocateDept();
				break;
			}
			case 3:{
				EmployeeDao.deAllocateDept();
				break;
			}
			
			case 4:{
				EmployeeDao.deAllocateOnDept();
				break;
			}
			case 5:{
				EmployeeDao.viewByDept();
				break;
			}
			case 6:{
				EmployeeDao.viewAll();
				break;
			}
			
			}
		}
		
	}
}
