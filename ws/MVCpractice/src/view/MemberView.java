package view;

import Util.ScInput;
import member.MemberController;

public class MemberView {
	
	public void showMenu() {
		
		System.out.println("===== 회원 =====");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 마이페이지");
		System.out.println("4. 회원탈퇴");
		
		int menu = ScInput.scInt();
		
		switch(menu) {
		case 1 : new MemberController().join(); break;			
		case 2 : break;			
		case 3 : break;			
		case 4 : break;
		default : System.out.println("다시 입력하세요."); break;
		}
		
	}

}
