package com.gaji.mini.view;

import java.util.Scanner;

import com.gaji.mini.post.controller.Board;
import com.gaji.mini.post.model.vo.Post;
import com.gaji.mini.run.GajiRun;

public class GajiMenu {

	String menu = "1. 회원 가입\n2. 로그인\n3. 탈퇴\n4. 종료";
	int choice = 0;

	public GajiMenu() {
		while (true) {
			System.out.println(menu);
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					break;

				default:
					try {
						System.out.println("잘못누르셨습니다.");
						Thread.sleep(2000);
						GajiRun.clearScreen();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
			}

		}

	}

}
