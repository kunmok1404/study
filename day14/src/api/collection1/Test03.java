package api.collection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		// 1. ����ڿ��� ����5���� �Է¹޾� List�� ����
		Scanner sc = new Scanner(System.in);
		List<Integer> num = new ArrayList<>();
		
		for(int i =0; i < 5; i++) {
			System.out.println((i+1) + "��° ���ڸ� �Է��ϼ���.");
			int n = sc.nextInt();
			num.add(n);
			// num.add(sc.nextInt());
		}
		sc.close();
		
		// 2. ����� ������ ���
		for(int i = 0; i < num.size(); i++) {
			System.out.println((i+1) + "��° ����� ���ڴ� " + num.get(i));
		}
		
		// 3. ¦�� ������ ��� ���
		int count = 0;
		for(int i = 0; i < num.size(); i++) {
			if(num.get(i) % 2 == 0) {
				count ++;
			}
		}
		System.out.println("¦�� ������ : " + count + "��");
	}
}
