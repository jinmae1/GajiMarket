package com.gaji.mini.view;

import java.util.Scanner;

import com.gaji.mini.controller.MemberManager;
import com.gaji.mini.model.vo.Member;

public class GajiMenu {
	Scanner sc = new Scanner(System.in);
	private MemberManager memberManager = new MemberManager();

	public void mainMenu() {
		String menu = "1. 회원가입\n" + "2. 로그인\n" + "3. 회원탈퇴\n" + "4. 프로그램 종료\n";

		while (true) {
			System.out.println(menu);
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					memberManager.registerMember(inputMember());
					break;

			case 2:
				break;

			case 3:
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
	// 사용자 입력을 받아서 Member객체 만들고, 리턴
	return new Member();
}
}



