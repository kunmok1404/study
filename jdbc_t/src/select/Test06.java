package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test06 {
	public static void main(String[] args) throws Exception{
		String id = "test";
		
//		DB ó��
//		select * from person where id='test';
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from person where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
//		rs�� ������ ������ �α��� ������ ����
		if(rs.next()) {
			System.out.println("�̹� ������� ���̵��Դϴ�.");
		}
		else {
			System.out.println("����� �� �ִ� ���̵��Դϴ�.");
		}
		
		con.close();
	}
}







