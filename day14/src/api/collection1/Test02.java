package api.collection1;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		
		// List ����
		List<String> list = new ArrayList<>();
		//List<String> list2 = new ArrayList<>(100000);
		
		// ����� ����
		
		
		// �߰�, ����, �˻�, ���� Ȯ��
		
		// add �� �ڿ� �����Ͱ� �߰�
		list.add("����");	// 0
		list.add("����");	// 1
		list.add("�嵿��");// 2
		list.add("������");// 3
		
		list.add(1, "����"); // 1��ġ�� ������ ����
		list.set(3, "������"); // 3��ġ�� �������� �����
		
		// get ���ϴ� ��ġ�� ������ Ȯ��
		System.out.println(list.get(3));
		
		// size ������ ���� ���� ��ȯ
		System.out.println(list.size());
		
		// ���
		System.out.println(list);
		
		// get�� size����� �̿��Ͽ� ����� ��� ������ ���
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
