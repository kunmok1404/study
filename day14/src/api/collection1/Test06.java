package api.collection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		
		// �����̸���� ����
		// ����ڿ��� ���� �̸��� �Է¹޾� ������ ����
		// ���ſ� �Է������� �ִ� �̸��� �Է��ϸ� ���ӿ��� - ���ӿ����� �׵��� �Է��ߴ� ��� �����̸��� ���
		
		List<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		// �Է�
		while(true) {
			System.out.println("���� �̸��� �Է��ϼ���.");
			String country = sc.next();
			if(list.contains(country)) {
				break;
			} 
			list.add(country);
		}
		sc.close();
		
		// ���
		System.out.println("���� ����");
		System.out.println("<�Է��� ��� ���� ���>");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
