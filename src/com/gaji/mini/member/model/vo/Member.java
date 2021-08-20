package com.gaji.mini.member.model.vo;

import java.io.Serializable;

import com.gaji.mini.item.model.vo.Item;

public abstract class Member implements Serializable {

	protected final String ID;
	protected String name;
	protected String pw;
	protected int money;
	protected Item[] items;

	public Member(String ID, String pw, String name) {
		this.ID = ID;
		this.pw = pw;
		this.name = name;
	}

	public String getID() {
		return ID;
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

	public void setMoney(int money) {
		this.money = money;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return name + "(" + ID + ")";
	}

}
