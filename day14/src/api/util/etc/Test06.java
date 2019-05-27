package api.util.etc;

import java.util.Random;

public class Test06 {
	public static void main(String[] args) {
		
		// �õ�(seed) ������ �����ϱ� ���� �ʱⰪ
		
		Random r = new Random();
		
		// �õ尡 ������ ������� ����
		r.setSeed(1L);
		System.out.println(r.nextInt());
		
		r.setSeed(1L);
		System.out.println(r.nextInt());
		
		// �ǵ������� �����ð����� �õ带 ���� ���� �� �ִ°�?
		// -> OTP���� ���α׷� ���� ����
		// -> �ð��� long���� ���ؿͼ� / ó��
		// -> system.currenttimemillis();
		
		while(true) {
			long time = System.currentTimeMillis() / 10000;
			r.setSeed(time);
			//System.out.println(time);
			System.out.println(r.nextInt(1000000));
		}
	}
}
