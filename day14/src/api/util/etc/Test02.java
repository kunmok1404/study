package api.util.etc;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		//String color = "빨강/주황/노랑/초록/파랑/남색/보라";
		String color = "빨강+주황-노랑*초록=파랑/남색@보라";
		
		Scanner sc= new Scanner(color);
		// Scanner는 직접 구분자(delimiter)를 설정할 수 있음
		sc.useDelimiter("[+*=/@-]");
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
		
	}
}
