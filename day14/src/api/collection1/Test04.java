package api.collection1;

import java.util.ArrayList;
import java.util.List;

public class Test04 {
	public static void main(String[] args) {
		
		// List의 다른 기능들
		// -검색 : contains()
		// -삭제 : remove(), clear()
		
		List<String> list = new ArrayList<>();
		
		list.add("노랑");
		list.add("빨강");
		list.add("초록");
		
		System.out.println(list.contains("빨강"));
		System.out.println(list.contains("주황"));
		
		list.remove("빨강");
		System.out.println(list);
		
	}
}
