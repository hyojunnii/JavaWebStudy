package menu;

import util.InputUtil;

public class Menu {
	
	// 메소드 == 동작 -> 메소드 명 작성시, 동사 형태로 작성 권장
	// 메뉴 보여주기
	public void showMenu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 게임하기");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. ");
//		inputMenu();
	}
	
	// 메뉴 선택 입력 받기
	public String inputMenu() {
		String input = InputUtil.inputStr();
		return input;
	}
	
}
