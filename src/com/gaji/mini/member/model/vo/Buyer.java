package com.gaji.mini.member.model.vo;

import com.gaji.mini.item.model.vo.Item;

public class Buyer extends Member {
	private String[] buyList;

	public Buyer(String ID, String pw, String name, int money) {
		super(ID, pw, name);
		this.money = money;
	}

	public void charge() {

	}

	public void buy() {

	}

}
