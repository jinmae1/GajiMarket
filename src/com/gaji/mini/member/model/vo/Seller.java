package com.gaji.mini.member.model.vo;

import java.util.Scanner;

import com.gaji.mini.item.model.vo.Item;
import com.gaji.mini.post.controller.Board;
import com.gaji.mini.post.model.vo.Post;

public class Seller extends Member {

	private float manner = 36.5f;
	private String[] sellList;

	public Seller(String ID, String pw, String name) {
		super(ID, pw, name);
	}

	public String[] getSellList() {
		return sellList;
	}

	public void setSellList(String[] sellList) {
		// TODO: sellList 배열이 아니라 string이 추가 되어야 함
		// * setSellList보다는 addSellList가 어울림
		this.sellList = sellList;
	}

	public void writePost(Post m) {


	}

	public int withDraw() {
		// Long drawMoney = sc.nextInt();
		// return this.getMoney() - drawMoney;
		return 0;
	}

	public void deletePost() {

	}
}
