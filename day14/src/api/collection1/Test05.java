package api.collection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
		
		// List�� ����� �̹��� �ζǹ�ȣ�� ��÷�Ͽ� ���� �� ���
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		
		for(int i = 0; i < 6; i++) {
			int lotto = r.nextInt(45) + 1;
				if(list.contains(lotto)) {
					System.out.println((i + 1) + "�� °�� �ߺ� �߻� : " + lotto );
					i--;
				} else {
					list.add(lotto);
				}		
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + "��° ��ȣ : " + list.get(i));
		}
	}
}
