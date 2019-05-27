package api.collection1;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		
		// List 배우기
		List<String> list = new ArrayList<>();
		//List<String> list2 = new ArrayList<>(100000);
		
		// 저장소 생성
		
		
		// 추가, 삭제, 검색, 개수 확인
		
		// add 맨 뒤에 데이터가 추가
		list.add("원빈");	// 0
		list.add("공유");	// 1
		list.add("장동건");// 2
		list.add("강동원");// 3
		
		list.add(1, "수지"); // 1위치에 수지를 삽입
		list.set(3, "아이유"); // 3위치를 아이유로 덮어쓰기
		
		// get 원하는 위치의 데이터 확인
		System.out.println(list.get(3));
		
		// size 데이터 저장 개수 반환
		System.out.println(list.size());
		
		// 출력
		System.out.println(list);
		
		// get과 size명령을 이용하여 저장소 모든 데이터 출력
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
