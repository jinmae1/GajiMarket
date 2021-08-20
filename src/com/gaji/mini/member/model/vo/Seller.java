package com.gaji.mini.member.model.vo;

import java.util.Scanner;

import com.gaji.mini.item.model.vo.Item;

public class Seller extends Member {
	Scanner sc = new Scanner(System.in);

	private String[] sellList;

	public Seller() {
	}

	public Seller(String[] sellList) {
		this.sellList = sellList;
	}

	public Seller(String iD, String name, String pw, long money, float manner, Item[] items) {
		super(iD, name, pw, money, manner, items);
	}

	public String[] getSellList() {
		return sellList;
	}

	public void setSellList(String[] sellList) {
		this.sellList = sellList;
	}

	public void post() {

	}

	public long withDraw() {
		// Long drawMoney = sc.nextInt();
		// return this.getMoney() - drawMoney;
		return 0;
	}

	public void deletePost() {

	}
}
