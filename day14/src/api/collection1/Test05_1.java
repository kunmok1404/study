package api.collection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test05_1 {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();

		// ù��° Ǯ��
		Random r = new Random();
		for(int i = 0; i < 7; i++) {
			int lotto = r.nextInt(45) + 1;
			if(!list.contains(lotto)) {
				list.add(lotto);
			} else {
				System.out.println("�ߺ� �߻�");
				i--;				
			}
		}
		
		// �ι�° Ǯ��
		while(list.size() < 7) {
			int lotto = r.nextInt(45) + 1;
			if(!list.contains(lotto)) {
				list.add(lotto);
			}
		}
		
		// ���
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
