package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test06_1 {
	public static void main(String[] args) throws Exception{
		String id = "test";
		
//		DB ó��
//		select count(*) from person where id='test';
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select count(*) from person where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
//		rs�� ������ �ְ�, �� ���� ������ ���ڰ� ���ΰ��� ���� �ٸ��� ó��
		rs.next();//���� ������ �̵�
//		int count = rs.getInt("count(*)");
		int count = rs.getInt(1);//ù��° ĭ
		if(count > 0) {
			System.out.println("�̹� ������� ���̵��Դϴ�.");
		}
		else {
			System.out.println("����� �� �ִ� ���̵��Դϴ�.");
		}
		
		con.close();
	}
}







