package api.util.etc;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		// Scanner에서  next()와 nextLine()을 섞어 쓰면 발생하는 문제
		
		Scanner sc = new Scanner(System.in);
		System.out.println("단어와 문장을 입력");
		String a = sc.next();
		String b = sc.nextLine();
		sc.close();
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
	}
}
