package view;

import Util.ScInput;
import member.MemberController;

public class MemberView {
	
	public void showMenu() {
		
		System.out.println("===== ȸ�� =====");
		System.out.println("1. ȸ������");
		System.out.println("2. �α���");
		System.out.println("3. ����������");
		System.out.println("4. ȸ��Ż��");
		
		int menu = ScInput.scInt();
		
		switch(menu) {
		case 1 : new MemberController().join(); break;			
		case 2 : break;			
		case 3 : break;			
		case 4 : break;
		default : System.out.println("�ٽ� �Է��ϼ���."); break;
		}
		
	}

}
