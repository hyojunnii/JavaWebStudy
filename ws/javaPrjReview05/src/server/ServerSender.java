package server;

import java.io.BufferedWriter;

public class ServerSender implements Runnable {

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
				//메세지큐에서 데이터 꺼내기
				String msg = ServerMain.msgQueue.poll();
				
				if(msg == null) continue;
				
				//꺼낸 데이터 보내기
				for (BufferedWriter bw : ServerMain.bwList) {
					bw.write(msg);
					bw.newLine();
					bw.flush();
				}
			} catch(Exception e) {
				System.out.println("메세지 전송 중 에러 발생 !!");
				e.printStackTrace();		
			}
			
			
		}
	}
	
}
