package main;

public class Main {

	public static void main(String[] args) {
		
		Person p1 = new Person("심원용", 20);
	
		
		p1.hello();
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		
		System.out.println(p1.toString());
		System.out.println(p1);
	}

}
