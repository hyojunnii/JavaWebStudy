package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReader implements Runnable{
	
	private final Socket s;
	
	public ServerReader(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			//메세지 읽기 무한반복
			while(true) {
				String msg = br.readLine();
				ServerMain.msgQueue.offer(msg);
			}
			
		} catch (IOException e) {
			System.out.println("서버 Reader 에러발생!!");
			e.printStackTrace();
		}
		
	}
	
	
}
