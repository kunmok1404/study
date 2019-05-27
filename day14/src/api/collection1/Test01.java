package api.collection1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		
		// JCF(Java Collection Framework)
		// -자바의 대용량 저장소
		// - 배열은 크기가 고정인 반면 Collection 은 크기가 가변
		// - 저장소에 따라 저장 원리와 구현 방식이 다름
		
		// -Set과 LIst 등 세분류가 존재
		
		// TreeSet과 ArrayList를 비교
		Collection<String> a = new TreeSet<>();
		Collection<String> b = new ArrayList<>();
		
		// 추가
		a.add("원빈");		b.add("원빈");
		a.add("공유");		b.add("공유");
		a.add("장동건");	b.add("장동건");
		a.add("강동원");	b.add("강동원");
		a.add("수지");		b.add("수지");
		
		// 출력
		System.out.println(a);
		System.out.println(b);
	}
}
