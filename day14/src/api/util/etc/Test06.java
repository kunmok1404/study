package api.util.etc;

import java.util.Random;

public class Test06 {
	public static void main(String[] args) {
		
		// 시드(seed) 랜덤을 생성하기 위한 초기값
		
		Random r = new Random();
		
		// 시드가 같으면 결과값이 같음
		r.setSeed(1L);
		System.out.println(r.nextInt());
		
		r.setSeed(1L);
		System.out.println(r.nextInt());
		
		// 의도적으로 일정시간동안 시드를 같게 만들 수 있는가?
		// -> OTP같은 프로그램 구현 가능
		// -> 시간을 long으로 구해와서 / 처리
		// -> system.currenttimemillis();
		
		while(true) {
			long time = System.currentTimeMillis() / 10000;
			r.setSeed(time);
			//System.out.println(time);
			System.out.println(r.nextInt(1000000));
		}
	}
}
