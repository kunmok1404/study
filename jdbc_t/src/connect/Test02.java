package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02 {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:xe", "study", "hard");
		
		//���� ~ ���� ���̿� ���ϴ� ����� �ۼ��� �� ���� ó��
		//��� ���� ���� : PreparedStatement
		//(����) ; �� ��ɿ� ����ϸ� ����
		String sql = "create table test1(value number primary key)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.execute();
		
		con.close();
		System.out.println("����!");
	}
}






