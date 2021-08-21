package com.gaji.mini.view;

import java.util.Scanner;

import com.gaji.mini.item.model.vo.Item;
import com.gaji.mini.lib.ScreenClear;
import com.gaji.mini.lib.TextColors;
import com.gaji.mini.member.model.vo.Buyer;
import com.gaji.mini.member.model.vo.Member;
import com.gaji.mini.member.model.vo.Seller;
import com.gaji.mini.post.controller.Board;
import com.gaji.mini.post.model.vo.Post;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);
	private Board board = new Board();
	private Member currentUser;
	String menu = "==============\n1. 게시판 조회\n" + "2. 상품 OO\n" + "3. 정보 조회\n" + "4. XX";

	public BoardMenu(Member logInMember) {
		this.currentUser = logInMember;

		if (currentUser instanceof Seller)
		{
			menu = menu.replace("00", "등록");
			menu = menu.replace("XX", "상품 생산");
			// menu = "==============\n1. 게시판 조회\n" + "2. 상품 등록\n" + "3. 정보 조회\n" + "4. 상품
			// 생산";
		}
		if (currentUser instanceof Buyer)
		{
			menu = menu.replace("00", "구매");
			menu = menu.replace("XX", "포인트 벌기");
			// menu = "==============\n1. 게시판 조회\n" + "2. 상품 구매\n" + "3. 정보 조회\n" + "4. 포인트
			// 벌기";
		}

		this.boardMenu();
	}

	public void boardMenu() {


		ScreenClear.clearScreen(500);
		while (true) {
			System.out.println(menu);
			System.out.print("> 입력: ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					board.listPosts();
					break;

				case 2:
					board.createPost(writePost((Seller) currentUser));
					break;

				case 3:
					showUserInfo(currentUser);
					break;

				case 0:
					return;

				default:
					System.out.println("잘못 입력하셨습니다.");
					try {

						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}

	private void showUserInfo(Member m) {
		System.out.println(m);
	}

	private Post writePost(Seller s) {
		int postNo;
		String itemName;
		int itemPrice = 0;
		Item item;
		String title;
		String content;

		ScreenClear.clearScreen(0);
		System.out.println("+++++ 상품 등록 ++++");

		System.out.print("글 번호: ");
		postNo = sc.nextInt();

		System.out.print("아이템 이름: ");
		itemName = sc.next();
		System.out.print("아이템 가격: ");
		itemPrice = sc.nextInt();
		item = new Item(itemName, itemPrice);

		sc.nextLine();
		System.out.print("제목: ");
		title = sc.nextLine();

		System.out.print("내용: ");
		content = sc.nextLine();

		return new Post(postNo, item, s.toString(), title, content);
	}

}
