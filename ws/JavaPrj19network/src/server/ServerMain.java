package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) throws IOException {

		//서버
		
		//서버소켓은 포트번호 필요
		//port 번호는 well-known 포트를 제외하고 사용가능
		ServerSocket ss = new ServerSocket(12345); 
		
		//accept 통해 클라 소켓 정보 얻음
		//쓰레드 수신대기(block)하다 연결시 client socket정보 return
		System.out.println("다른 소켓 연결 기다리는 중 ...");
		Socket cs = ss.accept(); 
		
		InetAddress ip = cs.getInetAddress();
	
		System.out.println("연결된 클라이언트의 ip : " + ip);
		
		//메세지 수신
		//stream 얻기
//		InputStream is = cs.getInputStream(); 				//1byte씩 처리
//		InputStreamReader isr = new InputStreamReader(is);  //이제 2byte씩 처리
//		BufferedReader br = new BufferedReader(isr); 		//보조스트림으로 성능 향상
		BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
	
		//메세지 읽고 출력하기
		String msg = br.readLine();
		System.out.println(msg);
		
		//사용한 자원 반납
		br.close();
	}

}//class
