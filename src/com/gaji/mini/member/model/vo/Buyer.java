package com.gaji.mini.member.model.vo;

import com.gaji.mini.item.model.vo.Item;

public class Buyer extends Member {
	private int money = 10000;
	private String[] buyList;

	public Buyer(String ID, String pw, String name) {
		super(ID, pw, name);
	}

	// TODO: setSellList 쪽 참고

	public void charge() {

	}

	public void buy() {

	}

}
