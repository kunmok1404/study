package api.collection1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//ī�带 ����� Ŭ����
public class CardGenerator {
	
	// �� ����� ī�� ��ü ����� �ǹ��ϴ� ����Դϴ�.
	public static final int All = 52;
	
	// �� �޼ҵ�� ���ϴ� ����ŭ ī�尡 Ƣ��ɴϴ�.
	public static List<String> getCard(int size){
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
		List<String> choice = card.subList(0, size); // 6��
		return choice;
	}

}
