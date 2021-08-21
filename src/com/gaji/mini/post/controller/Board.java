package com.gaji.mini.post.controller;

import java.util.*;

import com.gaji.mini.member.controller.MemberManager;
import com.gaji.mini.member.model.io.MemberIO;
import com.gaji.mini.member.model.vo.Seller;
import com.gaji.mini.post.model.io.PostIO;
import com.gaji.mini.post.model.vo.Post;

public class Board {

	private Map<Integer, Post> posts = new HashMap<>();
	private PostIO pio = new PostIO();
	private MemberManager memberManager = new MemberManager();
	private int postNo = 0; // readFile을 한 후 post의 개수만큼 카운트

	// TODO: post 생성 시 글번호(postNo) 부여
	// * 는 키값이며 post 객체 스스로가 생성하는 것이 아니라 게시판이(Board; PostManager)이 순차적으로 부여함
	// * 게시글이 삭제되어도 글번호는 유지됨
	// * create의 리턴값은 hashMap put의 리턴값과 동일(view에서 put 성공 여부에 사용)
	public Post createPost(Post p) {
		Post oldPost;
		posts = pio.readFile();
		oldPost = posts.put(p.getPostNo(), p); // ! 여기서 p.getPost()를 하면 안됨
		pio.writeFile(posts);

		return oldPost;
	}

	public Post deletePost(Seller s, int p) {
		posts.putAll(pio.readFile());
		// if (s.getPostedList().contains(p)) {
		Post temp = posts.remove(p);
		pio.writeFile(posts);

		return temp;
	}

	public Post getPost(int postNo) {
		posts.putAll(pio.readFile());
		return posts.get(postNo);
	}

	// TODO: editPost 작성
	// * 단 게시번호는 수정 불가

	public Map<Integer, Post> listPosts() {
		posts.putAll(pio.readFile());
		return posts;
	}

}
