package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 입력하세요.");
		int year = sc.nextInt();
		System.out.println("월을 입력하세요.");
		int month = sc.nextInt();
		sc.close();
		
		// 1. year년 month월 1일의 요일을 구해야 함.
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		
		int week = c.get(Calendar.DAY_OF_WEEK);
		//System.out.println(week);
		
		// 2. 설정된 날짜를 -(week-1)만큼 빼야함
		c.add(Calendar.DATE, -(week-1));
		SimpleDateFormat f = new SimpleDateFormat("y년 M월 d일");
		//System.out.println(f.format(c.getTime()));
		
		// 3. 출력
//		for(int i = 0; i < 35; i++) {
//			System.out.println(f.format(c.getTime()));
//			c.add(Calendar.DATE, 1);
//		}
		System.out.println("일\t월\t화\t수\t목\t금\t토\t");
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
