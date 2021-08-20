package com.gaji.mini.item.model.vo;

public class Item {
	private String ID;
	private int price;
	// private Member Owner;

	public Item() {
	}

	public Item(String iD, int price) {
		ID = iD;
		this.price = price;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
