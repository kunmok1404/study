package api.util.etc;

import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
		
		// Random 클래스
		Random r = new Random();
		System.out.println(r.nextInt(6)+1);
		System.out.println(r.nextBoolean());
		System.out.println(r.nextGaussian()); // 표준정규분호(-1 ~ 1 : 66%)
		
	}
}
