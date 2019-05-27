package api.util.etc;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		
		// scanner 입력보조 도구가 아니라 문자열 분해 클래스
		// 유사한 클래스로 StringTokenizer가 있음
		
		// 문자열 입력
		String song = "학교종이 땡땡땡 어서모이자\n선생님이 우리를 기다리신다";
		//System.out.println(song);
		Scanner s1 = new Scanner(song);
		
		// hasNext() 단어가 존재하는지 유무를 반환
		// next() 단어를 추출
		
		while(s1.hasNext()) {
			System.out.println(s1.next());
		}
		s1.close();
		
		// hasNextLine() 문장이 존재하는지 유무를 반환
		// nextLine() 문장을 추출
		
		Scanner s2 = new Scanner(song);
		while(s2.hasNextLine()) {
			System.out.println(s2.nextLine());
		}
		s2.close();
	}
}
