package main;

import Util.ScInput;
import view.MemberView;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== MVC Practice =====");
		
		System.out.println("1. ȸ��");
		System.out.println("2. ��������");
		System.out.println("3. �Խ���");
		System.out.println("4. ???");
		System.out.println("5. ???");
		
		int menu = ScInput.scInt();
		
		switch(menu) {
		case 1 : new MemberView().showMenu(); break;
		case 2 : break;
		case 3 : break;
		case 4 : break;
		case 5 : break;
		default : System.out.println("�ٽ� �Է��ϼ���"); break;
		}
		
		
		
	}//main

}//class
