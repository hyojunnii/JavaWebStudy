package member;

import Util.ScInput;

public class MemberController {

	public void join() {
		System.out.println("===== ȸ������ =====");
		
		System.out.print("���̵� : ");
		String id = ScInput.sc.nextLine();

		System.out.print("��й�ȣ : ");
		String pwd = ScInput.sc.nextLine();
		
		System.out.print("�г��� : ");
		String nick = ScInput.sc.nextLine();
		
		System.out.print("��ȭ��ȣ : ");
		String phone = ScInput.sc.nextLine();
		
		System.out.print("���� : ");
		String gender = ScInput.sc.nextLine();
		
		MemberVo vo = new MemberVo(id, pwd, nick, phone, gender);
		
		//�˻�, ��� ���� : MemberService
		int result = new MemberService().join(vo);
		
		//��� ���
		if(result == 1) {
			System.out.println("ȸ������ ���� !");
		} else if (result == -1) {
			System.out.println("��й�ȣ�� 4�ڸ� �̻��̾�� �մϴ�.");
		} else if (result == -2) {
			System.out.println("�ߺ��� ���̵��Դϴ�.");
		} else {
			System.out.println("ȸ������ ���� ..");
		}
	}//join

}
