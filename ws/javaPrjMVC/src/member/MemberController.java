package member;

import util.InputUtil;

public class MemberController {

	public void join() {
		System.out.println("===== ȸ������ =====");
		System.out.print("���̵� : ");
		String id = InputUtil.sc.nextLine();
		
		System.out.print("�н����� : ");
		String pwd = InputUtil.sc.nextLine();
		
		System.out.print("�г��� : ");
		String nick = InputUtil.sc.nextLine();
		
		System.out.print("��ȭ��ȣ : ");
		String phone = InputUtil.sc.nextLine();
		
		System.out.print("���� : ");
		String gender = InputUtil.sc.nextLine();
		
		MemberVo vo = new MemberVo(id, pwd, nick, phone, gender);
		
		int result = new MemberService().join(vo);
		
		//���� ����� ����, ȭ�� �����ֱ�
		if(result == 1) {
			System.out.println("ȸ������ ���� !");
		} else if (result == -1){
			System.out.println("��й�ȣ�� 4���� �̻��̾���մϴ�.");
		} else if (result == -2){
			System.out.println("�ٸ� ���̵� �Է����ּ���.");
		} else {
			System.out.println("ȸ������ ���� ...");
		}
	}

	public void login() {
		System.out.println("===== �α��� =====");
		
	}

	public void edit() {
		System.out.println("===== ȸ���������� =====");
		
	}

	public void quit() {
		System.out.println("===== Ż�� =====");
		
	}

}
