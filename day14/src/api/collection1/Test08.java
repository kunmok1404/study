package api.collection1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test08 {
	public static void main(String[] args) {
		
		// ���α׷� ���۽� �������� Ʈ���� ī�� �� ���� ��÷�Ͽ� ���
		// - ����� : ��Ʈ, ���̾Ƹ��, ũ���̵�, Ŭ�ι�
		// - ���� : A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K
		
		List<String> shape = Arrays.asList("��Ʈ", "���̾Ƹ��", "�����̵�", "Ŭ�ι�");
		List<String> number = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
		
		Collections.shuffle(shape);
		Collections.shuffle(number);
		
		String a = shape.get(0);
		String b = number.get(0);
		
		System.out.println("���� ī��� " + a + " " + b + " �Դϴ�.");
		
	}
}
