package api.util.etc;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		// Scanner����  next()�� nextLine()�� ���� ���� �߻��ϴ� ����
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ܾ�� ������ �Է�");
		String a = sc.next();
		String b = sc.nextLine();
		sc.close();
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
	}
}
