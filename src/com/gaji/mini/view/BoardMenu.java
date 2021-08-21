package com.gaji.mini.view;

import java.util.Scanner;

import com.gaji.mini.lib.ScreenClear;
import com.gaji.mini.post.controller.Board;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);
	private Board board = new Board();

	public BoardMenu() {
	}

	public void boardMenu() {

		String menu = "==============\n1. 게시판 조회\n" + "2.글 등록\n" + "3. 0000\n" + "4. 0000\n"
				+ "0. 이전 메뉴로\n==============";

		ScreenClear.clearScreen(500);
		while (true) {
			System.out.println(menu);
			System.out.print("> 입력");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					// board.createPost(writePost())
					break;

				case 2:
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

}
