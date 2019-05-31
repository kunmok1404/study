package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test07 {
	public static void main(String[] args) throws Exception{
		String id = "test";
		String pw = "test";
		
//		DB �α��� ó��
//		select * from person where id=? and pw=?;
//		select count(*) from person where id=? and pw=?;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from person where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
//		close() ������ rs.next()�� ���� ���
		boolean result = rs.next();
				
		con.close();
		
		if(result) {
			System.out.println("�α��� ����");
		}
		else {
			System.out.println("�α��� ����");
		}
	}
}








