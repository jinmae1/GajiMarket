package com.gaji.mini.member.model.vo;

import java.util.Scanner;

import com.gaji.mini.item.model.vo.Item;

public class Seller extends Member {
	Scanner sc = new Scanner(System.in);

	private float manner = 36.5f;
	private String[] sellList;

	public Seller(String ID, String pw, String name, Item[] items) {
		super(ID, pw, name);
	}

	public String[] getSellList() {
		return sellList;
	}

	public void setSellList(String[] sellList) {
		this.sellList = sellList;
	}

	public void post() {

	}

	public int withDraw() {
		// Long drawMoney = sc.nextInt();
		// return this.getMoney() - drawMoney;
		return 0;
	}

	public void deletePost() {

	}
}
