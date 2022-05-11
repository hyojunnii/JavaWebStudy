package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List list = new ArrayList<String>();
		list.add("수지");
		list.add("아이유");
		list.add("강동원");
		list.add("남주혁");
		list.add("김태리");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		System.out.println(list.get(2));
		System.out.println(list.get(list.size()-1));
		list.remove(list.size()-2);
		
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
