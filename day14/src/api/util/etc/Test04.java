package api.util.etc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		
		// Scanner�� ���� �б�
		File f = new File("song.txt");
		Scanner sc = new Scanner(f);
		
		String bf = new String();
		StringBuffer buffer = new StringBuffer(); // ����ִ� �����
		while(sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			bf += sc.nextLine() + "\n";
		}
		sc.close();
		System.out.println(buffer.toString());
	}
}
