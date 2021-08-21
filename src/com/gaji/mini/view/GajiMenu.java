package com.gaji.mini.view;

import java.util.Map;
import java.util.Scanner;

import com.gaji.mini.item.model.vo.Item;
import com.gaji.mini.lib.ScreenClear;
import com.gaji.mini.member.controller.MemberManager;
import com.gaji.mini.member.model.vo.*;
import com.gaji.mini.post.model.vo.Post;

public class GajiMenu {
	Scanner sc = new Scanner(System.in);
	private MemberManager memberManager = new MemberManager();
	private String memberType;

	public void mainMenu() {
		String menu = "==============\n1. 구매자 회원가입\n" + "2. 사업자 회원가입\n" + "3. 회원 탈퇴\n" + "4. 로그인\n" + "9. 전체 회원\n"
				+ "0. 프로그램 종료\n==============";

		ScreenClear.clearScreen(500);
		while (true) {
			System.out.println(menu);
			System.out.print("> 입력: ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					// TODO: 지금은 바로 가입이지만 판매자,구매자를 해당 메뉴에서 분리하든지 하위 메뉴로 가기
					memberManager.addMember(inputMember("buyer"));
					break;

				case 2:
					memberManager.addMember(inputMember("seller"));
					break;

				case 3:
					// * 판매자인지 구매자인지 선택 후 회원이 존재하는지 확인
					// TODO: if(memberManger.UserExists())
					System.out.println(memberManager.removeMember(inputID(), inputPW()));
					break;

				case 4:
					// TODO: 로그인 후 화면 만들기
					String id = inputID();
					Member member;
					Seller seller;
					memberType = memberManager.checkMemberType(id);
					if ("buyer".equals(memberType)) {
						System.out.println(memberManager.getMember(id));
					} else if ("seller".equals(memberType)) {
						seller = (Seller) memberManager.getMember(id);
						seller.writePost(new Post(1, new Item("book", 1000), seller, "This is a book", "It's old"));
					}

					break;

				case 9:
					memberManager.listMembers();
					// ScreenClear.clearScreen(3000);

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

	private String inputID() {
		System.out.print("ID: ");
		return sc.next();
	}

	private String inputPW() {
		System.out.print("PW: ");
		return sc.next();
	}

	private String inputName() {
		System.out.print("Name: ");
		return sc.next();
	}

	private Member inputMember() {
		String id;
		String pw;
		ScreenClear.clearScreen(0);
		System.out.println("==== 회원탈퇴 ====");
		id = inputID();
		pw = inputPW();

		return new Buyer(id, pw, null);
	}

	private Member inputMember(String memberType) {
		String id;
		String pw;
		String name;

		ScreenClear.clearScreen(0);
		System.out.println("==== " + memberType + " 회원가입 ====");
		id = inputID();
		/**
		 * TODO: ID 같으면 여기서 중복체크 바로 하고 중복 시 return; * id.equals(member.getID() 하지 말고
		 * key값으로 비교하기)
		 */

		pw = inputPW();
		name = inputName();
		ScreenClear.clearScreen(0);
		// 사용자 입력을 받아서 Member객체 만들고, 리턴
		// return new Member();
		if ("buyer".equals(memberType))
			return new Buyer(id, pw, name);
		else if ("seller".equals(memberType))
			return new Seller(id, pw, name);
		else
			return null; // error

	}
}



