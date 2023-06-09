package com.tjl.controller;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_imp;
import com.tjl.view.*;

public class control {

	public static void main(String[] args) {
		while(true) {
		User user=View.indexView();
		UserDao_imp userDao_imp=new UserDao_imp();
		int type =userDao_imp.login(user);
		if(type==-1) {
			System.out.println("Input error");
		}else if(type==1) {
			System.out.println("Congratulations to the Store Manager for logging in");
			managerServer();
		}else if(type==2) {
			System.out.println("Congratulations to the Employee for logging in");
			employeeServer();
		}
		}
	}

	private static void managerServer() {
		UserDao_imp userDao_imp=new UserDao_imp();
		while(true) {
		int item=View.managerMenuView();
		boolean flag;
		switch(item) {
		case 0:
			System.exit(-1);
			break;			
		case 1:
			User user=View.addMenuView();
			flag=userDao_imp.insert(user);
			if(flag==true) {
				System.out.println("Added successfully");
			}else {
				System.out.println("Add failed");
			}
			break;
		case 2:
			String uname=View.deleteMenuView();
			flag=userDao_imp.delete(uname);
			System.out.println(flag?"Deleted successfully":"Delete failed");
			break;
		case 3:
			User updateUser=View.updataMenuView();
			flag=userDao_imp.update(updateUser);
			System.out.println(flag?"Updated successfully":"Update failed");
			break;
		case 4:
			String uanme1=View.selectMenuView();
			User selectedUser=userDao_imp.select(uanme1);
			View.printUser(selectedUser);
			break;
		case 5:
			break;
		case 6:
			break;		
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		}
		
	}
	}
	private static void employeeServer() {
		UserDao_imp userDao_imp=new UserDao_imp();
		while(true) {
			int item=View.employeeMenuView();
			boolean flag;
			switch(item) {
			case 0:
				System.exit(-1);
				break;			
			case 1:
				User updateUser=View.updataMenuView();
				flag=userDao_imp.update(updateUser);
				System.out.println(flag?"Updated successfully":"Update failed");
				break;
			case 2:
				String uanme1=View.selectMenuView();
				User selectedUser=userDao_imp.select(uanme1);
				View.printUser(selectedUser);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
		}
		
	}
	}

}
