package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws Exception {
//		����ڿ��� ���̵� / ��й�ȣ / �̸��� �Է¹޾� �߰�
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.nextLine();
		System.out.println("�̸��� �Է��ϼ���");
		String name = sc.nextLine();
		sc.close();
		
//		�����ͺ��̽� ó��
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:xe", "study", "hard");
		
		String sql = "insert into person values("
				+ "person_seq.nextval, '"+id+"', '"+pw+"', '"+name+"', 2000, sysdate)";
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		
		con.close();
		System.out.println("����!");
	}
}



















