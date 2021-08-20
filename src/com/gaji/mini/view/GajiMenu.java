package com.gaji.mini.view;

import java.util.Scanner;

import com.gaji.mini.lib.ScreenClear;
import com.gaji.mini.member.controller.MemberManager;
import com.gaji.mini.member.model.io.MemberIO;
import com.gaji.mini.member.model.vo.Buyer;
import com.gaji.mini.member.model.vo.Member;

public class GajiMenu {
	Scanner sc = new Scanner(System.in);
	private MemberManager memberManager = new MemberManager();

	public void mainMenu() {
		String menu = "==============\n1. 회원가입\n" + "2. 로그인\n" + "3. 회원탈퇴\n" + "4. 프로그램 종료\n==============";

		ScreenClear.clearScreen(500);
		while (true) {
			System.out.println(menu);
			System.out.print("> 입력: ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					// TODO: 지금은 바로 가입이지만 판매자,구매자를 해당 메뉴에서 분리하든지 하위 메뉴로 가기
					memberManager.addMember(inputMember());
					break;

			case 2:
				System.out.println(memberManager.listMembers());
				ScreenClear.clearScreen(3000);
				break;

			case 3:
				memberManager.listMembers();

				break;

			case 4:
				break;

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

private Member inputMember() {
	String id;
	String name;
	String pw;
	int money;

	ScreenClear.clearScreen(0);
	System.out.println("==== 회원가입 ====");
	System.out.print("ID: ");
	/**
	 * TODO: ID 같으면 여기서 중복체크 바로 하고 중복 시 return; * id.euqals(member.getID() 하지 말고
	 * key값으로 비교하기)
	 */
	id = sc.next();
	System.out.print("Password: ");
	pw = sc.next();
	System.out.print("Name: ");
	name = sc.next();
	System.out.print("Money: ");
	money = sc.nextInt();
	ScreenClear.clearScreen(0);
	// 사용자 입력을 받아서 Member객체 만들고, 리턴
	// return new Member();
	return new Buyer(id, pw, name, money);
}
}



