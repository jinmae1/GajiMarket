package com.gaji.mini.post.model.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.gaji.mini.item.model.vo.Item;
import com.gaji.mini.member.model.vo.Seller;

public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int postNo; // Key Value
	private Item item;
	private Seller postedBy;
	private String title;
	private String content;
	private boolean isSold;
	private LocalDateTime postedAt;

	public Post(int postNo, Item item, Seller postedBy, String title, String content) {
		this.postNo = postNo;
		this.item = item;
		this.postedBy = postedBy;
		this.title = title;
		this.content = content;
	}

	public int getPostNo() {
		return this.postNo;
	}

	// ! postNo는 controller에 의해서 결정되고 key값이기 때문에 set은 불필요
	// public void setPostNo(int postNo) {
	// this.postNo = postNo;
	// }

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Seller getPostedBy() {
		return this.postedBy;
	}

	public void setPostedBy(Seller postedBy) {
		this.postedBy = postedBy;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isIsSold() {
		return this.isSold;
	}

	public void setIsSold(boolean isSold) {
		this.isSold = isSold;
	}

	public LocalDateTime getPostedAt() {
		return this.postedAt;
	}

	public void setPostedAt(LocalDateTime postedAt) {
		this.postedAt = postedAt;
	}

}
