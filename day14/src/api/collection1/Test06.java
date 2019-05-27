package api.collection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		
		// 나라이름대기 게임
		// 사용자에게 나라 이름을 입력받아 게임을 진행
		// 과거에 입력한적이 있는 이름을 입력하면 게임오버 - 게임오버시 그동안 입력했던 모든 나라이름을 출력
		
		List<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		// 입력
		while(true) {
			System.out.println("나라 이름을 입력하세요.");
			String country = sc.next();
			if(list.contains(country)) {
				break;
			} 
			list.add(country);
		}
		sc.close();
		
		// 출력
		System.out.println("게임 오버");
		System.out.println("<입력한 모든 나라 목록>");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
