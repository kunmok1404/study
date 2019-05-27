package api.collection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		// 1. 사용자에게 숫자5개를 입력받아 List에 저장
		Scanner sc = new Scanner(System.in);
		List<Integer> num = new ArrayList<>();
		
		for(int i =0; i < 5; i++) {
			System.out.println((i+1) + "번째 숫자를 입력하세요.");
			int n = sc.nextInt();
			num.add(n);
			// num.add(sc.nextInt());
		}
		sc.close();
		
		// 2. 저장된 데이터 출력
		for(int i = 0; i < num.size(); i++) {
			System.out.println((i+1) + "번째 저장된 숫자는 " + num.get(i));
		}
		
		// 3. 짝수 개수를 세어서 출력
		int count = 0;
		for(int i = 0; i < num.size(); i++) {
			if(num.get(i) % 2 == 0) {
				count ++;
			}
		}
		System.out.println("짝수 개수는 : " + count + "개");
	}
}
