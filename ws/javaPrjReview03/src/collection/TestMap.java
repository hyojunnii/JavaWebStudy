package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
	
	public void test01() {
		Map<String, Integer> m = new HashMap();
		
		m.put("슬리퍼", 3000);
		m.put("크런키", 1000);
		m.put("양파링", 1500);
		m.put("고래밥", 1200);
		
		Set<String> s = m.keySet();
		System.out.println(s);
		for(String temp : s) {
			System.out.println(temp);
		}
		
		System.out.println(m);
	}
}
