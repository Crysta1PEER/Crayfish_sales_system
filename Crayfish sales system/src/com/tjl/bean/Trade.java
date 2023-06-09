package com.tjl.bean;

public class Trade {

	private int ware_id;
	private String trade_name;
	private int quantity;
	
	public Trade() {
		super();
	}
	
	public Trade(String trade_name, int quantity) {
		super();
		this.trade_name = trade_name;
		this.quantity = quantity;
	}

	public Trade(int ware_id, String trade_name, int quantity) {
		super();
		this.ware_id = ware_id;
		this.trade_name = trade_name;
		this.quantity = quantity;
	}
	
	public User(int id, String uname, String upass, int type) {
		super();
		this.id = id;
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upass=" + upass + ", type=" + type + "]";
	}
	
	
}
