package api.collection1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test08_2 {
	public static void main(String[] args) {
		
		List<String> shape = Arrays.asList("��Ʈ", "���̾Ƹ��", "�����̵�", "Ŭ�ι�");
		List<String> number = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
		
		// ī�带 1�� �뤊�� ����
		List<String> card = new ArrayList<>();
		
		// ��� �ݺ�
		for(int i = 0; i < shape.size(); i++) {
			for(int j = 0; j < number.size(); j++) {
				//System.out.println( shape.get(i) + " " + number.get(j));
				card.add(shape.get(i) + " " + number.get(j));
			}
		}
		//System.out.println(card);
		Collections.shuffle(card);
		//System.out.println(card.get(0));
		
		// ����Ʈ ���� : subList(��������, ��������)
		List<String> choice = card.subList(0, 6); // 6��
		System.out.println(choice);
	}
}
