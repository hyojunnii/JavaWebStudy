package main;

public class Main2 {

	public static void main(String[] args) {

		String name1 = Thread.currentThread().getName();
		System.out.print(name1 + " : ");
		System.out.println("===== 쓰레드 =====");
		
		Thread t = new TestThread2();
		String name = t.getName();
		System.out.print(name + " : ");
		t.start();
		
		
//		test();
		
	}
	
	//static에서는 static을 호출해야함
	//public void는 객체가 있어야 실행되기 때문 (static은 항상 존재)
	public static void test() {

		//이스케이프 문자 : \
		
		System.out.println("\"안녕!\""); //"안녕!"
		System.out.println("안\n녕"); //줄바꿈
		System.out.println("안\r녕"); //줄바꿈
		System.out.println("안\t녕"); //안		녕
		System.out.println("\\");
		
		//printf : format지정
		System.out.println("==== printf test ====");
		System.out.printf("%s", "abc"); //%s : string출력
		System.out.println();
		System.out.printf("%d", 10);
		System.out.println();
		System.out.printf("%c", 'a');
	}

}//class
