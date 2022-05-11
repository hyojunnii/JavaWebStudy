package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Set hs = new HashSet<Integer>();
		
		for (int i = 0; i < 11; i++) {
			hs.add(i);
		}
		
//		for (int i = 0; i < hs.size(); i++) {
//			System.out.println(i);
//		}

		Iterator<Integer> iter = hs.iterator();
		
		while(iter.hasNext()) {
			int result = iter.next();
			System.out.println(result);
		}
		
		System.out.println(hs.contains(8));
		
	}

}
