package com.kh.kfc.obj;

import java.util.Scanner;

import com.kh.kfc.main.Main;

public class MenuSide {

	Scanner sc = new Scanner(System.in);

	// 햄버거 메뉴 보여주기

	public void showMenuSide() {
		System.out.println("======== 사이드 ========");
		System.out.println("1. 감자튀김 (2000원)");
		System.out.println("2. 어니언링 (3000원)");
		System.out.println("3. 치킨윙 (4000원)");

		int menu = Integer.parseInt(sc.nextLine());

		switch (menu) {
		case 1:
			Main.total += 2000;
			Main.menuAll += "감자튀김 ";
			System.out.println("감자튀김을 선택하셨습니다.");
			break;
		case 2:
			Main.total += 3000;
			Main.menuAll += "어니언링 ";
			System.out.println("어니언링을 선택하셨습니다.");
			break;
		case 3:
			Main.total += 4000;
			Main.menuAll += "치킨윙 ";
			System.out.println("치킨 윙을 선택하셨습니다.");
			break;
		default:
			System.out.println("그런 메뉴 없음");

		}
	}
}
