package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�⵵�� �Է��ϼ���.");
		int year = sc.nextInt();
		System.out.println("���� �Է��ϼ���.");
		int month = sc.nextInt();
		sc.close();
		
		// 1. year�� month�� 1���� ������ ���ؾ� ��.
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		
		int week = c.get(Calendar.DAY_OF_WEEK);
		//System.out.println(week);
		
		// 2. ������ ��¥�� -(week-1)��ŭ ������
		c.add(Calendar.DATE, -(week-1));
		SimpleDateFormat f = new SimpleDateFormat("y�� M�� d��");
		//System.out.println(f.format(c.getTime()));
		
		// 3. ���
//		for(int i = 0; i < 35; i++) {
//			System.out.println(f.format(c.getTime()));
//			c.add(Calendar.DATE, 1);
//		}
		System.out.println("��\t��\tȭ\t��\t��\t��\t��\t");
		System.out.println("--------------------------------");
		for(int i = 0; i < 35; i++) {
			System.out.print(c.get(Calendar.DATE) + "\t");
			
			if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				System.out.println();
			}
		c.add(Calendar.DATE, 1);
		}
	}
}
