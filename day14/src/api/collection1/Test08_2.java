package api.collection1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test08_2 {
	public static void main(String[] args) {
		
		List<String> shape = Arrays.asList("하트", "다이아몬드", "스페이드", "클로버");
		List<String> number = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
		
		// 카드를 1덱 통쨰로 구현
		List<String> card = new ArrayList<>();
		
		// 모양 반복
		for(int i = 0; i < shape.size(); i++) {
			for(int j = 0; j < number.size(); j++) {
				//System.out.println( shape.get(i) + " " + number.get(j));
				card.add(shape.get(i) + " " + number.get(j));
			}
		}
		//System.out.println(card);
		Collections.shuffle(card);
		//System.out.println(card.get(0));
		
		// 리스트 분할 : subList(시작지점, 종료지점)
		List<String> choice = card.subList(0, 6); // 6장
		System.out.println(choice);
	}
}
