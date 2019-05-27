package api.collection1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test07 {
	public static void main(String[] args) {
		
		// Collection�� ���� ������ Collections
		
//		List<Integer> list = new ArrayList<>();
//		for(int i = 1; i <= 10; i++) {
//			list.add(i);
//		}
//		System.out.println(list.get(i));
		
		// 1.8���� �����Ǵ� ��� - ������ ����(�Һ�)
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(list.getClass());
		
		// ������(reverse)
		Collections.reverse(list);
		System.out.println(list);
		
		// ����(shuffle)
		Collections.shuffle(list);
		System.out.println(list);
		
		// ����(sort)
		Collections.sort(list);
		System.out.println(list);
	}
}
