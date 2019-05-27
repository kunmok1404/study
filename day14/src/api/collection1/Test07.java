package api.collection1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test07 {
	public static void main(String[] args) {
		
		// Collection의 보조 도구인 Collections
		
//		List<Integer> list = new ArrayList<>();
//		for(int i = 1; i <= 10; i++) {
//			list.add(i);
//		}
//		System.out.println(list.get(i));
		
		// 1.8부터 제공되는 기능 - 간편한 생성(불변)
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(list.getClass());
		
		// 뒤집기(reverse)
		Collections.reverse(list);
		System.out.println(list);
		
		// 셔플(shuffle)
		Collections.shuffle(list);
		System.out.println(list);
		
		// 정렬(sort)
		Collections.sort(list);
		System.out.println(list);
	}
}
