package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Set set = new HashSet<Integer>();
		
		for (int i = 0; i < 11; i++) {
			set.add(i);
		}
		System.out.println(set.contains(8));
		
//		for (int i = 0; i < set.size(); i++) {
//			System.out.println(i);
//		}
		
		//iterator
		Iterator<Integer> iter = set.iterator();
		
//		while(true) {
//			if(!iter.hasNext()) {
//				break;
//			}
//			
//			if(iter.hasNext()) {
//				int result = iter.next();
//				System.out.println(result);
//			}
//		}
		
		while(iter.hasNext()) {
			int result = iter.next();
			System.out.println(result);
		}
		
		
	}

}
