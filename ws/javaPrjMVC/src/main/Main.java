package main;

import util.InputUtil;
import view.MemberView;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== MVC ������Ʈ =====");
		
		System.out.println("1. ȸ��");
		System.out.println("2. �Խ���");
		System.out.println("3. ��������");
		System.out.println("4. ������");
		System.out.println("5. ???");
		
		int menu = InputUtil.scanInt();
		
		switch(menu) {
		case 1 : new MemberView().showMenu(); break;
		case 2 : break;
		case 3 : break;
		case 4 : break;
		case 5 : break;
		}
		
	
	}//main

}//class
