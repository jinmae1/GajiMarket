package com.gaji.mini.member.model.vo;

import com.gaji.mini.item.model.vo.Item;

public abstract class Member {

	private String ID;
	private String name;
	private String pw;
	private long money;
	private float manner;
	private Item[] items;

	public Member() {
	}

	public Member(String ID, String name, String pw, long money, float manner, Item[] items) {
		this.ID = ID;
		this.name = name;
		this.pw = pw;
		this.money = money;
		this.manner = manner;
		this.items = items;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public float getManner() {
		return manner;
	}

	public void setManner(float manner) {
		this.manner = manner;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

}
