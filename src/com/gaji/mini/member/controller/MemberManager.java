package com.gaji.mini.member.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;​
import 가지.manager.Member;​

public class MemberManager {
	Scanner sc = new Scanner(System.in);
	final String dir = "database/";
	final String file = "board.txt";
	Member member = new Member();

	Map<Integer, Member> board = new HashMap<>(); // 게시글
	{
		board.put(new board(1), new board(new Item(item), );
		board.put(2, new board());
		board.put(3, new board());
		board.put(4, new board());
	}

	Map<String, Member> seller = new HashMap<>(); // 판매자
	{
		seller.put("123", new Member());
		seller.put("234", new Member());
		seller.put("456", new Member());
	}

	Map<String, Member> buyer = new HashMap<>(); // 구매자
	{
		buyer.put("123", new Member());
		buyer.put("234", new Member());
		buyer.put("456", new Member());
	}

	/*
	 * 컨트롤러
	 * 
	 * 게시판 보여주기 게시글등록()
	 * 
	 * 회원등록 인출() 충전() 구매()
	 * 
	 * 
	 * 
	 * 흥정?()
	 */

	// 회원 등록 //구매자와 판매자 나눔
	public void memberRegi() {
		while (true) {
			System.out.println("판매자와 구매자 선택 : ");
			String sellbuy = sc.next();

			if ("구매자".equals(sellbuy)) {
				System.out.println("id 등록 : ");
				String id = sc.next();

				buyer.put(id, new Member());

				System.out.println("등록 완료");
				break;
			}

			else if ("판매자".equals(sellbuy)) {
				System.out.println("id 등록 : ");
				String id = sc.next();

				seller.put(id, new Member());

				System.out.println("등록 완료");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
	}

	// 게시글 보기
	public void fileview() {
		Map<Integer, Member> boardview = null;

		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dir + file)));
			boardview = (Map<Integer, Member>) ois.readObject();
			for (int i = 0; i < boardview.size(); i++) {
				System.out.println(boardview.toString());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 게시글 쓰기 //
	public void filewrite() {
​
				try(
					FileWriter fw = new FileWriter(file, true);
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dir+file));
				){
						
					oos.writeObject(board);
					System.out.println(file+"저장 완료");
					// 실제파일에 쓰기
				} catch (IOException e) {
					e.printStackTrace();
					
				}
	}

	// 충전
	public int chargingMoney() {
		
		System.out.println("판매자와 구매자 선택 : ");
		String  sellbuy= sc.next();
		System.out.println("id 입력 : ");
		String id = sc.next();
		
		
		if("구매자".equals(sellbuy)) {
			
		for(String key : buyer.keySet())
			if(id.contains(buyer.get(key).getID())) {
				return buyer.get(key).getMoney() += 1000;
			}
​
		
		System.out.println("충전 완료");
		break;
		}
		
		else if("판매자".equals(sellbuy)) {
			System.out.println("id 등록 : ");
			String id = sc.next();		
			
			seller.put(id, new Member());
			
			System.out.println("등록 완료");
			break;
		}
		else{
			System.out.println("잘못 입력하셨습니다.");
			continue;
		}
​
//		for(int i = 0 ; i<member.memberList.size(); i++) {
//			if(id.equals(member.memberList.get(i).getID())) {
//				return member.memberList.get(i).setMoney() += 1000; //1000원 충전
//			}
//		}
		
		
	}

	// 구매 // 구매 후 게시글했던 글 삭제?
	public void buy(String str) {

		for (int i = 0; i < member.memberList.size(); i++) {
			if (str.equals(member.memberList.get(i).getItem())) {
				System.out.println(
						member.memberList.get(i).getID() + " 의" + member.memberList.get(i).getItem() + "판매 완료");
				member.memberList.get(i).getItem() = null;
			}
		}
		// TODO: 판매자 돈 + , 구매자 돈 -

	}

	// 인출
	public int withdraw(String id, int money) {

		for (int i = 0; i < member.memberList.size(); i++) {
			if (id.equals(member.memberList.get(i).getID())) {
				return member.memberList.get(i).setMoney() -= money; // 1000원 충전
			}
		}

	}

	​
}
