package api.util.etc;

import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
		
		// Random Ŭ����
		Random r = new Random();
		System.out.println(r.nextInt(6)+1);
		System.out.println(r.nextBoolean());
		System.out.println(r.nextGaussian()); // ǥ�����Ժ�ȣ(-1 ~ 1 : 66%)
		
	}
}
