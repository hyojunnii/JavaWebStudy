package collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public void test01() {
		Set<String> s = new HashSet();
		
		s.add("일");
		s.add("월");
		s.add("금");
		s.add("금");
		s.add("목");
		s.add("금");
		s.add("토");
		
		s.iterator();
		
		for(String str : s) {
			System.out.println(str);
		}
		
		System.out.println(s);
	}
	
}
