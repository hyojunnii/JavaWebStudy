package member;

import Util.ScInput;

public class MemberController {

	public void join() {
		System.out.println("===== 회원가입 =====");
		
		System.out.print("아이디 : ");
		String id = ScInput.sc.nextLine();

		System.out.print("비밀번호 : ");
		String pwd = ScInput.sc.nextLine();
		
		System.out.print("닉네임 : ");
		String nick = ScInput.sc.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = ScInput.sc.nextLine();
		
		System.out.print("성별 : ");
		String gender = ScInput.sc.nextLine();
		
		MemberVo vo = new MemberVo(id, pwd, nick, phone, gender);
		
		//검사, 디비에 저장 : MemberService
		int result = new MemberService().join(vo);
		
		//결과 출력
		if(result == 1) {
			System.out.println("회원가입 성공 !");
		} else if (result == -1) {
			System.out.println("비밀번호는 4자리 이상이어야 합니다.");
		} else if (result == -2) {
			System.out.println("중복된 아이디입니다.");
		} else {
			System.out.println("회원가입 실패 ..");
		}
	}//join

}
