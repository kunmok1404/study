package api.util.etc;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		//String color = "����/��Ȳ/���/�ʷ�/�Ķ�/����/����";
		String color = "����+��Ȳ-���*�ʷ�=�Ķ�/����@����";
		
		Scanner sc= new Scanner(color);
		// Scanner�� ���� ������(delimiter)�� ������ �� ����
		sc.useDelimiter("[+*=/@-]");
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
		
	}
}
