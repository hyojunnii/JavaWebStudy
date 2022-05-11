package member;

import java.util.Scanner;

public class MemberController {

	public void memberJoin() {
		Scanner sc = new Scanner(System.in);

		System.out.println("===== 회원가입 진행 =====");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		//회원가입 가능 여부 체크
		boolean checkResult = checkMember(id);
		if(checkResult) {
			insertMember(id,pwd);
		} else {
			System.out.println("회원가입 실패!");
		}
		
	}
	
	// 비즈니스 로직 처리 (service 로직)
	private boolean checkMember(String id) {
		// 아이디 중복 체크해서, 결과 리턴
		// 아이디가 관리자를 사칭할 위험이 있으면 실패 처리
		if("admin".equals(id)) {
			return false;
//		} else if(/*어떤 경우*/) {
//			return false;
		} else {
			return true;
		}
	}

	// 데이터 저장 (data 로직)
	private void insertMember(String id, String pwd) {
		//파일 객체 생성
		//파일 객체로부터 스트림 생성
		//스트림 이용해서 데이터 저장
		System.out.println("회원가입 완료 !");
	}
	
}
