package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Map map = new HashMap<String, Integer>();
		
		map.put("일", 1);
		map.put("이", 2);
		map.put("삼", 3);
		map.put("사", 4);
		map.put("오", 5);
		
		Set<Map.Entry<String, Integer>> es = map.entrySet();
		// Map.Entry == Entry
		
		Iterator<Entry<String, Integer>> iter = es.iterator();
		
		while(iter.hasNext()) {
			Entry<String, Integer> x = iter.next();
			System.out.print(x.getKey() + " : ");
			System.out.println(x.getValue());
		}
		
//		System.out.println(map.get("삼"));
//		
//		System.out.println(map.keySet());
//		System.out.println(map.values());
//		System.out.println(map.entrySet());
		
//		Collection<Integer> vvv = map.values(); //iterator로 변환 가능
//		System.out.println(vvv);
		
//		int result = map.get("일");
//		System.out.println(result);
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String k = it.next();
			System.out.print(k + " : ");
			System.out.println(map.get(k));
		}
	}

}
