package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01 {
	public static void main(String[] args) throws Exception{
//		select * from food �� �ڹٷ� ó��
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from food";
		PreparedStatement ps = con.prepareStatement(sql);
//		ps.execute();//������ ������ ������տ� ������ �Ұ�
		ResultSet rs = ps.executeQuery();//���� �� ������� ���� ��ȯ
		
//		��� : rs.next() , rs.getString() , rs.getInt()
		while(rs.next()) {
			System.out.println(rs.getString("type"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("price"));
		}
		
		con.close();
		System.out.println("����!");
	}
}






