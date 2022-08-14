package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import common.Reader;
import common.Sender;

public class ClientMain {
	
	public static String name;

	public static void main(String[] args) {

		//보낼 메세지 입력받기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사용자 이름 : ");
		name = "[" +  sc.nextLine() + "] ";
		
		System.out.print("접속 ip : ");
		String ip = sc.nextLine();
		
		System.out.print("접속 port : ");
		String port_ = sc.nextLine();
		int port = Integer.parseInt(port_);
		
		try {
			Socket s = new Socket(ip, port);
			
			//소켓을 이용해서 데이터 주고받기
			//데이터 보내는 쓰레드 생성
			new Thread(new Sender(s)).start();
			//데이터 받는 쓰레드 생성
			new Thread(new Reader(s)).start();
			
			System.out.println("접속 완료!");
			
		} catch (IOException e) {
			System.out.println("소켓 생성중 에러 발생!!");
			e.printStackTrace();
		}
		
	}

}
