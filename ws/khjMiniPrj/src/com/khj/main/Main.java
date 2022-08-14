package com.khj.main;

import com.khj.board.Board;
import com.khj.member.Member;
import com.khj.util.MyUtil;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("=================");
		System.out.println("khj mini prj");
		
		while(true) {
			
			System.out.println("=================");
			System.out.println("1. ȸ������");
			System.out.println("2. �α���");
			System.out.println("3. �Խñ� �ۼ�");
			System.out.println("4. �Խñ� ��ȸ");
			System.out.println("5. 555");
			System.out.println("=================");
			
			
			int n = MyUtil.scInt();
			
			switch(n) {
			case 1 : new Member().join(); break;
			case 2 : new Member().login(); break;
			case 3 : new Board().write(); break;
			case 4 : new Board().showList(); break;
			case 5 : break;
			default : System.out.println("�ٽ� �����ϼ���");
			}
			
		}
		
	}

}
