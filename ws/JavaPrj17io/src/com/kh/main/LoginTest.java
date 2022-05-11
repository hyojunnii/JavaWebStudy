package com.kh.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoginTest {

	Scanner sc = new Scanner(System.in);

	private final String path = "D:\\220407dev\\user.txt";
	
	public void login() {
		
		//사용자 로그인
//		System.out.println("로그인");
		String[] strArr = inputUser();
		
		String id = strArr[0];
		String pwd = strArr[1];
		
		//파일에서 아이디, 비번 확인하여
		//로그인 가능 여부 판단하기
		
		//파일객체 생성
		File f = new File(path);
		
		//스트림 생성
		// try with resource 구문을 사용하면, close 처리를 따로 할 필요가 없다.
			// ()안에 두면 스트림 등 자동 close됨
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
									//보조스트림      //메인스트림
			boolean isLoginSuccess = false;
			
			while(true) {
				//아이디, 비번 읽기
				String data = br.readLine();
				
				//data가 null이라면 읽기끝
				if(data == null) {break;}
				
				//ID,PWD구분
				int index = data.indexOf('/');
				String dataId = data.substring(0,index);
				String dataPwd = data.substring(index + 1);
				
				//판단하기
				if(id.equals(dataId) && pwd.equals(dataPwd)) {
					System.out.println(dataId + "님 로그인 성공");
					isLoginSuccess = true;
					break;
				}
			}
			
			//한번도 성공 못하면 출력
			if (!isLoginSuccess) {
				System.out.println("로그인 실패");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("예외 !");
		} catch (IOException e1) {
			System.out.println("IO 예외 !");
		}
	}
	
	//회원가입
	public void join() throws JoinException {
		System.out.println("회원가입");
		String[] strArr = inputUser();
		
		String id = strArr[0];
		String pwd = strArr[1];

		//아이디, 패스워드 중에 '/' 있으면 예외 발생시키기
		if(id.contains("/") || pwd.contains("/")) {
			throw new JoinException();
					//커스텀 예외 사용 : 다른 예외 처리 안하기 위해
		}
		
		//입력받은 데이터를 파일에 넣기
		File f = new File(path);
		
		//스트림 생성
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(f, true)); //boolean append(이어쓰기)
			bw.write(id);
			bw.write("/");
			bw.write(pwd);
			bw.write("\n");
			bw.flush(); //받은 데이터 파일로 밀어주기
		} catch (IOException e) {
			System.out.println("예외발생");
		} finally {
			try {bw.close();} catch (IOException e){e.printStackTrace();}
			//스트림 종료 : 스트림에 사용되고 있는 자원 놓아주기
		}
	}
	
	//ID,PWD 입력받는 메소드
	public String[] inputUser() {
		System.out.print("ID : ");
		String id = sc.nextLine().trim(); //trim : 문자열 공백 제거
		System.out.print("PWD : ");
		String pwd = sc.nextLine().trim();
		
		return new String[] {id,pwd};
//		String[] strArr = new String[2];
//		strArr[0] = id;
//		strArr[1] = pwd;
//		return strArr;
	}
	
}//class
