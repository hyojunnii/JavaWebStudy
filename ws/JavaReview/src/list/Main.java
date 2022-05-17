package list;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<Person>();
		list.add(new Person("수지",20));
		list.add(new Person("아이유",20));
		list.add(new Person("강동원",30));
		list.add(new Person("김태리",20));
		list.add(new Person("남주혁",30));
		
		for (Person x : list) {
			System.out.println(x);
		}
		
		
		List<String> li = new ArrayList<String>();
		li.add("수지");
		li.add("아이유");
		li.add("강동원");
		li.add("김태리");
		li.add("남주혁");
		
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
		System.out.println();
		
		System.out.println(li.get(2));
		System.out.println(li.get(li.size()-1));
		li.remove(li.size()-2);
		
	}

}
