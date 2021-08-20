package com.gaji.mini.run;

import com.gaji.mini.view.GajiMenu;

public class GajiRun {

	public static void main(String[] args) {
		new GajiMenu().mainMenu();
	}

	public static void clear() {

		try {
			Thread.sleep(2000);

			for (int i = 0; i < 80; i++)
				System.out.println("");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
