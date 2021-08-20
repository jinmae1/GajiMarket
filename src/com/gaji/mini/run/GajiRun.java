package com.gaji.mini.run;

import com.gaji.mini.view.GajiMenu;

public class GajiRun {
	public static void main(String[] args) {
		String loading = "로딩";
		clearScreen();
		try {
			for (int i = 0; i < 5; i++) {
				loading += '.';
				System.out.println(loading);
				Thread.sleep(1000);
				clearScreen();

			}
			System.out.println("로딩 완료");
			Thread.sleep(3000);
			clearScreen();
			GajiMenu gm = new GajiMenu();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void clearScreen() {
		for (int i = 0; i < 80; i++) {
			System.out.println();

		}
	}

	public static void lclearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
