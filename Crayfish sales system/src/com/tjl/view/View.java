package com.tjl.view;

import java.util.Scanner;

import com.tjl.bean.User;

public class View {
	
	private static Scanner input=new Scanner(System.in);
	
	public static User indexView() {
		System.out.println("*****************************************************************");
		System.out.println("******\t\tCrayfish Sales System    \t\t*********");
		System.out.println("******\t\tPlease Follow The Prompts\t\t*********");
		System.out.println("******\t\tPlease Enter Your Account:\t\t*********");
		String uname=input.nextLine();
		System.out.println("******\t\tPlease Enter Your Password:\t\t*********");
		String upass=input.nextLine();
		System.out.println("*****************************************************************");
		System.out.println("*****************************************************************");		
		return new User(uname,upass);		
	}
	
	public static int managerMenuView() {
		System.out.println("*****************************************************************");
		System.out.println("******\t\tWelcome Store Manager    \t\t*********");
		System.out.println("******\t\tPlease Follow The Prompts\t\t*********");
		System.out.println("******\t\t0.Exit\t\t\t\t\t*********");
		System.out.println("******\t\t1.Add Employee Information\t\t*********");
		System.out.println("******\t\t2.Delete Employee Password\t\t*********");
		System.out.println("******\t\t3.Update Employee Information\t\t*********");
		System.out.println("******\t\t4.Show Employee Information\t\t*********");
		System.out.println("******\t\t5.Add Warehouse Information\t\t*********");
		System.out.println("******\t\t6.Delete Warehouse Information\t\t*********");
		System.out.println("******\t\t7.Show Warehouse Information\t\t*********");
		System.out.println("******\t\t8.Add Order Information\t\t\t*********");
		System.out.println("******\t\t9.Delete Order Information\t\t*********");
		System.out.println("******\t\t10.Show Order Information\t\t*********");
		
		
		String type=input.nextLine();
		int item=Integer.parseInt(type);
		if(item<0||item>10)
		{
			System.out.println("Input Error, Please Re-enter");
			return managerMenuView();
		}
		
		System.out.println("*****************************************************************");
		System.out.println("*****************************************************************");		
		return item;		
	}
	
	public static int employeeMenuView() {
		System.out.println("*****************************************************************");
		System.out.println("******\t\tWelcome Store Employee    \t\t*********");
		System.out.println("******\t\tPlease Follow The Prompts\t\t*********");
		System.out.println("******\t\t0.Exit\t\t\t\t\t*********");
		System.out.println("******\t\t1.Update Password\t\t\t*********");
		System.out.println("******\t\t2.Show Employee Information\t\t*********");
		System.out.println("******\t\t3.Add Warehouse Information\t\t*********");
		System.out.println("******\t\t4.Delete Warehouse Information\t\t*********");
		System.out.println("******\t\t5.Show Warehouse Information\t\t*********");
		System.out.println("******\t\t6.Add Order Information\t\t\t*********");
		System.out.println("******\t\t7.Delete Order Information\t\t*********");
		System.out.println("******\t\t8.Show Order Information\t\t*********");
		
		
		String type=input.nextLine();
		int item=Integer.parseInt(type);
		if(item<0||item>8)
		{
			System.out.println("Input Error, Please Re-enter");
			return managerMenuView();
		}
		
		System.out.println("*****************************************************************");
		System.out.println("*****************************************************************");		
		return item;		
	}

	public static User addMenuView() {
		System.out.println("*****************************************************************");
		System.out.println("******\t\tPlease Follow The Prompts\t\t*********");
		System.out.println("******\t\tPlease Enter Employee Account:\t\t*********");
		String uname=input.nextLine();
		System.out.println("******\t\tPlease Enter Employee Password:\t\t*********");
		String upass=input.nextLine();
		System.out.println("*****************************************************************");
		System.out.println("*****************************************************************");
		return new User(uname,upass);
	}
	
	public static String deleteMenuView() {
	System.out.println("***********************************************************");
	System.out.println("**********\tPlease Follow The Prompts\t***********");
	System.out.println("**********\tPlease Enter Employee Account:\t***********");
	String uname = input.nextLine();
	System.out.println("***********************************************************");
	return uname;
	}
	
	public static User updataMenuView() {
	System.out.println("***********************************************************");
	System.out.println("**********\tPlease Follow The Prompts\t***********");
	System.out.println("**********\tPlease Enter Account:\t***********");
	String uname = input.nextLine( );
	System.out.println("**********\tPlease Enter New Password:\t***********");
	String upass = input.nextLine();
	System.out.println("***********************************************************");
	return new User(uname,upass);
	}
	
	public static String selectMenuView() {
	System.out.println("***********************************************************");
	System.out.println("**********\tPlease Follow The Prompts\t***********");
	System.out.println("**********\tPlease Enter Employee Account:\t\t***********");
	String uname = input.nextLine();
	System.out.println("***********************************************************");
	return uname;	
	}

	public static void printUser(User user) {
		System.out.println("id:"+user.getId());
		System.out.println("uname:"+user.getUname());
		System.out.println("upass:"+user.getUpass());
		if(user.getType()==1) 
		{
			System.out.println("User permissions:Manager");
		}
		else if(user.getType()==2)
		{
			System.out.println("User permissions:Employee");
		}
	}

}
