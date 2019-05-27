package api.collection1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test08 {
	public static void main(String[] args) {
		
		// 프로그램 시작시 랜덤으로 트럼프 카드 한 장을 추첨하여 출력
		// - 모양은 : 하트, 다이아몬드, 크페이드, 클로버
		// - 숫자 : A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K
		
		List<String> shape = Arrays.asList("하트", "다이아몬드", "스페이드", "클로버");
		List<String> number = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
		
		Collections.shuffle(shape);
		Collections.shuffle(number);
		
		String a = shape.get(0);
		String b = number.get(0);
		
		System.out.println("뽑은 카드는 " + a + " " + b + " 입니다.");
		
	}
}
