package api.util.etc;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		
		// scanner �Էº��� ������ �ƴ϶� ���ڿ� ���� Ŭ����
		// ������ Ŭ������ StringTokenizer�� ����
		
		// ���ڿ� �Է�
		String song = "�б����� ������ �������\n�������� �츮�� ��ٸ��Ŵ�";
		//System.out.println(song);
		Scanner s1 = new Scanner(song);
		
		// hasNext() �ܾ �����ϴ��� ������ ��ȯ
		// next() �ܾ ����
		
		while(s1.hasNext()) {
			System.out.println(s1.next());
		}
		s1.close();
		
		// hasNextLine() ������ �����ϴ��� ������ ��ȯ
		// nextLine() ������ ����
		
		Scanner s2 = new Scanner(song);
		while(s2.hasNextLine()) {
			System.out.println(s2.nextLine());
		}
		s2.close();
	}
}
