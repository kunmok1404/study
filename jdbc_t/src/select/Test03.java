package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) throws Exception {
//		����ڰ� �Է��� �з��� �ش��ϴ� �����͸� FOOD ���̺��� ��ȸ
		Scanner sc = new Scanner(System.in);
		System.out.println("�з��� �Է��ϼ���");
		String type = sc.nextLine();
		sc.close();
		
//		�����ͺ��̽� ó��
//		select * from food where type=?
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from food where type=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, type);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					rs.getString("name")+"("+rs.getInt("price")+"��)");
		}
		
		con.close();
		
	}
}







