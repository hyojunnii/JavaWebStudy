package temp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		/*
		1. Map 타입 객체 생성
		2. Map 의 key는 문자열, value는 정수 로 제한하기
		3. Map 에 5개의 문자열-정수 쌍 데이터 넣기
		4. 특정 key로 value 꺼내서 출력해보기
		5. 모든 키 값 확인해보기 (출력)
		6. 모든 value 확인해보기 (출력)
		7. 모든 key - value 쌍 확인해보기 (출력)
		 */
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("하나", 1);
		map.put("둘", 2);
		map.put("삼", 3);
		map.put("넷", 4);
		map.put("오", 5);
		
		Set<Map.Entry<String, Integer>> es = map.entrySet();
		
		Iterator<Entry<String, Integer>> iter = es.iterator();
		
		while(iter.hasNext()) {
			Entry<String , Integer> x = iter.next();
			System.out.print(x.getKey() + " : ");
			System.out.println(x.getValue());
		}
		
		
//		Collection<Integer> vvv = map.values(); //iterator 로 변환 가능
//		System.out.println(vvv);
		
//		int result = map.get("하나");
//		System.out.println(result);
		
//		Iterator<String> iter = map.keySet().iterator();
//		
//		while(iter.hasNext()) {
//			String k = iter.next(); //키 한개씩 꺼내옴
//			System.out.print(k + " : ");
//			System.out.println(map.get(k));
//		}
		
		
		
		/*
		1. Set 타입 객체 생성
		2. 정수만 들어가도록 제한하기
		3. 5개의 정수 넣기
		4. 모든 값 출력해보기
		5. 정수 n이 해당 객체에 포함되어 있는지 확인해보기
		 */
		
//		Set set = new HashSet<Integer>();
//		set.add(10);
//		set.add(20);
//		set.add(30);
//		set.add(40);
//		set.add(50);
//		
//		boolean result = set.contains(30);
//		System.out.println(result);
//		
		//iterator
//		Iterator<Integer> iter = set.iterator();
		
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
		
//		while(iter.hasNext()) {
//			int result = iter.next();
//			System.out.println(result);
//		}
		
		
		/*
		 *  1. List 타입 객체 생성
			2. 문자열만 담을 수 있도록 제한
			3. 연예인 이름 n명 넣기
			4. 모든 연예인 이름 출력해보기 (반복문으로)
			5. 그 중 3번째 연예인 이름 출력해보기
			6. 마지막(뒤에서 첫번째) 연예인 이름 출력해보기
			7. 뒤에서 두번째 연예인 이름 삭제하기
		 */
		
		//제네릭
//		List<Person> list = new ArrayList<Person>();
//		
//		list.add(new Person("심원용", 11));
//		list.add(new Person("심투용", 22));
//		list.add(new Person("심삼용", 33));
//		list.add(new Person("심넷용", 44));
//		list.add(new Person("심오용", 55));
//		
//		for(Person x : list) {
//			System.out.println(x);
//		}
		
		
		
//		list.add("심원용");
//		list.add("심투용");
//		list.add("심삼용");
//		list.add("심사용");
//		list.add("심오용");
		
//		list.remove(list.size()-2); //특정 인덱스의 요소를 삭제할 수 있다.
		
//		int n = list.size()-1; //4
//		System.out.println(list.get(n));
		
		//향상된 for문
//		for(String x : list) {
//			System.out.println(x);
//		}
		
//		for(int i = 0 ; i < list.size(); ++i) {
//			System.out.println(list.get(i));
//		}
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
//		System.out.println(list.get(4));
		
		
		/*
		1. 문자열 하나 만들기
		2. n번째 문자 출력하기
		3. n번째 부터 m 번째 문자열 출력하기
		4. "hello" 라는 문자열과 같은지 확인하기
		5. "abc" 라는 문자열을 포함하고 있는지 확인하기
		6. 해당 문자열이 가지는 특정 문자의 인덱스 값 알아내기
		7. 특정 문자열을 구분자로 하여 문자배열 얻어내기
		 */
		
//		String str = "abc 안녕 hello hi";
		
//		char ch = str.charAt(5); //특정 인덱스의 문자 반환
//		System.out.println(ch);
		
//		String result = str.substring(2,5);
//		System.out.println(result);
		
//		str.equals("hello") //문자열 같은지 비교
//		"hello".equals(str) //문자열 같은지 비교
		
//		str.contains("abc"); //해당문자열을 가지고 있는지 비교 가능
		
//		int idx = str.indexOf("안");
//		System.out.println(idx);
		
		//"abc 안녕 hello hi"
//		String[] strArr = str.split(" ");
//		
//		System.out.println(strArr[0]);
//		System.out.println(strArr[1]);
//		System.out.println(strArr[2]);
//		System.out.println(strArr[3]);
		
		
	}
}
