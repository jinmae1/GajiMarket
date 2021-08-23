package com.gaji.mini.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.gaji.mini.item.model.vo.Item;
import com.gaji.mini.lib.ScreenClear;
import com.gaji.mini.lib.TextColors;
import com.gaji.mini.member.controller.MemberManager;
import com.gaji.mini.member.model.vo.Buyer;
import com.gaji.mini.member.model.vo.Member;
import com.gaji.mini.member.model.vo.Seller;
import com.gaji.mini.post.controller.Board;
import com.gaji.mini.post.model.vo.Post;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);
	private Board board = new Board();
	private MemberManager membermManager = new MemberManager();
	private Member currentUser;
	private Seller currentSeller;
	private Buyer currentBuyer;
	String menu = "==============\n1. 게시판 조회\n" + "2. 상품 OO\n" + "3. 정보 조회\n" + "4. XX\n" + "5. 상품 삭제\n" + "0. 돌아가기";

	public BoardMenu(Member logInMember) {
		this.currentUser = logInMember;

		if (currentUser instanceof Seller) {
			this.currentSeller = (Seller) logInMember;
			menu = menu.replace("OO", "등록");
			menu = menu.replace("XX", "인출");
			// menu = "==============\n1. 게시판 조회\n" + "2. 상품 등록\n" + "3. 정보 조회\n" + "4. 상품
			// 생산";
		}
		if (currentUser instanceof Buyer) {
			this.currentBuyer = (Buyer) logInMember;
			menu = menu.replace("OO", "구매");
			menu = menu.replace("XX", "충전");
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

			try {

				switch (choice) {
					case 1:
						sort(board.listPosts());
						// Map<Integer, Post> posts = board.listPosts();
						// for (Integer key : posts.keySet()) {
						// Post p = posts.get(key);
						// System.out.println("번호: " + p.getPostNo() + "\t" + "제목: " + p.getTitle() +
						// "\t" + "상품이름: "
						// + p.getItem().getName());

						// }
						// 게시글 내용 조회
						int postNo = selectPostNo();
						showPost(postNo);
						break;

					case 2:
						if (currentSeller != null)
							board.createPost(currentSeller, writePost(currentSeller));
						// 상품 등록
						if (currentBuyer != null) {
							System.out.print("구매할 상품 번호");
							board.buyItem(currentBuyer, sc.nextInt());
						}
						break;

					case 3:
						showUserInfo(currentUser);
						System.out.println(membermManager.getMoney(currentUser) + "원");
						// 로그인 유저 정보 출력

						if (currentSeller != null) {
							System.out.println(currentSeller.getPostedList());
							for (Integer postKey : currentSeller.getPostedList())
								System.out.println(board.getPost(Integer.valueOf(postKey)));
						}

						// if (currentBuyer != null)
						// System.out.println(membermManager.getMoney(currentUser) + "원");

						break;

					case 4:
						System.out.print("충전금액: ");
						membermManager.charge(currentUser, sc.nextInt());
						System.out.println("현재 금액: " + membermManager.getMoney(currentUser) + "원");
						break;

					case 5:
						if (currentSeller != null) {
							System.out.print("postNo: ");
							int selectedNo = sc.nextInt();
							System.out.println(board.deletePost((Seller) currentUser, selectedNo));
							// 삭제
						}
						break;

					case 0:
						currentBuyer = null;
						currentSeller = null;
						return;

					default:
						System.out.println("잘못 입력하셨습니다.");
						try {

							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			} catch (NullPointerException e) {

			}
		}

	}

	private void sort(Map<Integer, Post> p) {
		Map<Integer, Post> pMap = new TreeMap<>(p);
		for (Integer key : pMap.keySet()) {
			Post post = pMap.get(key);
			if (post.isSold())
				System.out.println(post.getPostNo() + ". " + post.getTitle() + " " + post.getPostedBy() + " "
						+ post.getPostedAt() + " " + TextColors.colorText("판매완료", TextColors.PURPLE));
			else
				System.out.println(post.getPostNo() + ". " + post.getTitle() + " " + post.getPostedBy() + " "
						+ post.getPostedAt() + " " + "판매중");
			// TODO: postedby의 toSTring 수정
		}
	}

	private void showPost(int postNo) {
		ScreenClear.clearScreen(0);
		Post temp = board.getPost(postNo);
		// 여기서 보여주고 사용자가 돌아가기(ex -1 등을 누르면 게시판 메뉴로 가기)
		System.out.println("글 번호: " + temp.getPostNo() + "\n" + "제목: " + temp.getTitle() + "\n======================\n"
				+ temp.getItem().getName() + " (" + temp.getItem().getPrice() + "원)\n\n" + "내용: " + temp.getContent());

		System.out.print("\n> 돌아가기(9): ");
		// TODO: 여기 고치기
		sc.nextInt();

	}

	private int selectPostNo() {
		// 스캐너로 입력받고 입력 받은 값을 리턴
		System.out.println("> 게시글 선택(No): ");

		return sc.nextInt();
	}

	private void showUserInfo(Member m) {
		System.out.println(membermManager.getMember(m.getID()));
		// System.out.println(m);
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
		sc.nextLine();

		System.out.print("아이템 이름: ");
		itemName = sc.nextLine();
		System.out.print("아이템 가격: ");
		itemPrice = sc.nextInt();
		item = new Item(itemName, itemPrice);

		sc.nextLine();
		System.out.print("제목: ");
		title = sc.nextLine();

		System.out.print("내용: ");
		content = sc.nextLine();

		s.addToPostedList(postNo);
		System.out.println("_______++++++++++++++____________________");
		System.out.println(s.getPostedList());
		System.out.println("_______++++++++++++++____________________");
		return new Post(postNo, item, s.getID(), title, content);

	}

}
