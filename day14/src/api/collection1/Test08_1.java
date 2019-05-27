package api.collection1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test08_1 {
	public static void main(String[] args) {
		
		List<String> shape = Arrays.asList("하트", "다이아몬드", "스페이드", "클로버");
		List<String> number = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
		
		Random r= new Random();
		int s = r.nextInt(shape.size());
		int n = r.nextInt(number.size());
		
		System.out.print(shape.get(s));
		System.out.print(" ");
		System.out.println(number.get(n));
	}
}
