package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test01_1 {
	public static void main(String[] args) throws Exception{
//		��� 2���� -> ���� ?�� , ���� ?��
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.nextLine();
		
//		�α��� ó��
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from person where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		boolean login = rs.next();
		con.close();//DB �۾��� �������Ƿ� ���� ����... ���߿� �ʿ��ϸ� �翬��
		
		if(login) {
			System.out.println("������ ��й�ȣ�� �Է��ϼ���");
			String npw = sc.nextLine();
			
			//�翬��
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
			
			sql = "update person set pw=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, npw);
			ps.setString(2, id);
			ps.execute();
			System.out.println("��й�ȣ ������ �Ϸ�Ǿ����ϴ�");
		}
		else {
			System.out.println("�α��� ������ ��ġ���� �ʽ��ϴ�");
		}
		
		con.close();
		sc.close();
	}
}





