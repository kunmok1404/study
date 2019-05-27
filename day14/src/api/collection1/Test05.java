package api.collection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
		
		// List를 만들어 이번주 로또번호를 추첨하여 저장 및 출력
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		
		for(int i = 0; i < 6; i++) {
			int lotto = r.nextInt(45) + 1;
				if(list.contains(lotto)) {
					System.out.println((i + 1) + "번 째에 중복 발생 : " + lotto );
					i--;
				} else {
					list.add(lotto);
				}		
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + "번째 번호 : " + list.get(i));
		}
	}
}
