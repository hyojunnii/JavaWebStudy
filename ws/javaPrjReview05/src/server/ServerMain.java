package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServerMain {
	
	public static final Queue<String> msgQueue = new LinkedList<>();
	public static final List<BufferedWriter> bwList = new ArrayList<>();

	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(12345);
			
			//데이터 보내는 쓰레드 - 1회만
			new Thread(new ServerSender()).start();
			
			while(true) {
				System.out.println("연결 대기중 ...");
				Socket s = ss.accept();
				System.out.println(s.getRemoteSocketAddress() + "연결됨 ..");
				
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				bwList.add(bw);
				
				//데이터 읽는 쓰레드
				new Thread(new ServerReader(s)).start();
			}
		} catch (IOException e) {
			System.out.println("서버 죽음 ..");
			e.printStackTrace();
		}
	}

}
