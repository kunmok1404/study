package api.collection1;

import java.util.ArrayList;
import java.util.List;

public class Test04 {
	public static void main(String[] args) {
		
		// List�� �ٸ� ��ɵ�
		// -�˻� : contains()
		// -���� : remove(), clear()
		
		List<String> list = new ArrayList<>();
		
		list.add("���");
		list.add("����");
		list.add("�ʷ�");
		
		System.out.println(list.contains("����"));
		System.out.println(list.contains("��Ȳ"));
		
		list.remove("����");
		System.out.println(list);
		
	}
}
