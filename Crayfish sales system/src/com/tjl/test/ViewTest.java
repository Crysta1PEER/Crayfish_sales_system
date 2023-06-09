package com.tjl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.view.View;

public class ViewTest {
	@Test
	public void indexViewTest() throws Exception {
		User user1=View.indexView();
		System.out.println(user1);
	}
	@Test
	public void managerMenuView() throws Exception {
		int item=View.managerMenuView();
		System.out.println(item);
	}
	@Test
	public void addMenuViewTest() throws Exception {
		User user=View.addMenuView();
		System.out.println(user);
	}
	@Test
	public void deleteMenuViewTest() throws Exception {
		String uname=View.deleteMenuView();
		System.out.println(uname);
	}
	@Test 
	public void updataMenuViewTest() throws Exception {
		User user2=View.updataMenuView();
		System.out.println(user2);
	}
	@Test
	public void selectMenuViewTest() throws Exception {
		String uname=View.selectMenuView();
		System.out.println(uname);
	}
}
