package client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//클라이언트
		System.out.println("클라이언트 시작");
		
		//접속 할 서버 소켓 정보 인자로 전달 (발신)	
		//("서버소켓ip주소", 서버소켓port번호)
		Socket s = new Socket("127.0.0.1",12345); //127.0.0.1 == localhost
		
		//메세지 발신
		//stream 얻기
		OutputStream os = s.getOutputStream();				 //1바이트
		OutputStreamWriter osw = new OutputStreamWriter(os); //2바이트
		BufferedWriter bw = new BufferedWriter(osw); 		 //보조스트림으로 성능향상
		
		//입력받고, write 해주기
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
	
		bw.write(msg);
		bw.flush();

		//사용한 자원 반납
		bw.close();
	}
	
}//class
