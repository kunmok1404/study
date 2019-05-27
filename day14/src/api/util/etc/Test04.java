package api.util.etc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		
		// Scanner로 파일 읽기
		File f = new File("song.txt");
		Scanner sc = new Scanner(f);
		
		String bf = new String();
		StringBuffer buffer = new StringBuffer(); // 비어있는 저장소
		while(sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			bf += sc.nextLine() + "\n";
		}
		sc.close();
		System.out.println(buffer.toString());
	}
}
