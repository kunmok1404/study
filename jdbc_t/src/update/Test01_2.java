package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test01_2 {
//	�α��� �޼ҵ�
	public static boolean login(String id, String pw) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from person where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		boolean login = rs.next();
		con.close();
		
		return login;
	}
//	��й�ȣ ���� �޼ҵ�
	public static void change(String id, String npw) throws Exception{
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "update person set pw=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, npw);
		ps.setString(2, id);
		ps.execute();
		con.close();
	}
	
	public static void main(String[] args) throws Exception{
//		��� 2���� -> ���� ?�� , ���� ?��
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.nextLine();
		
//		�α��� ó��
		if(login(id, pw)) {
			System.out.println("������ ��й�ȣ�� �Է��ϼ���");
			String npw = sc.nextLine();
			
			//�翬��
			change(id, npw);
			System.out.println("��й�ȣ ������ �Ϸ�Ǿ����ϴ�");
		}
		else {
			System.out.println("�α��� ������ ��ġ���� �ʽ��ϴ�");
		}
		
		sc.close();
	}
}





