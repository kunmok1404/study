package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) throws Exception{
//		�˻��� �Է¹ޱ�		
		Scanner sc = new Scanner(System.in);
		System.out.println("ã���� ���̵� �Է��ϼ���");
		String key = sc.nextLine();
		sc.close();
		
//		�����ͺ��̽� ó��
//		select * from person where id like '%a%' order by id asc;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from person "
				+ "where id like '%' || ? || '%' order by id asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, key);
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("���̵� : "+rs.getString("id"));
		}
		
		con.close();
		
	}
}








