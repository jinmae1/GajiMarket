package com.gaji.mini.post.controller;

import java.util.*;

import com.gaji.mini.post.model.vo.Post;

public class Board {

	private Map<Integer, Post> posts = new HashMap<>();

	public Post CreatePost(Post p) {
		return posts.put(p.getPostNo(), p);
	}

	public Post deletePost(Post p) {
		return posts.remove(p.getPostNo());
	}

	public Map<Integer, Post> listPosts() {
		return posts;
	}

}
