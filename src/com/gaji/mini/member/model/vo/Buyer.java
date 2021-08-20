package com.gaji.mini.member.model.vo;

import com.gaji.mini.item.model.vo.Item;

public class Buyer extends Member {

	private String[] buyList;

	public Buyer() {
	}

	public Buyer(String iD, String name, String pw, long money, float manner, Item[] items) {
		super(iD, name, pw, money, manner, items);
	}

	public Buyer(String[] buyList) {
		this.buyList = buyList;
	}

	public void charge() {

	}

	public void buy() {

	}
}
