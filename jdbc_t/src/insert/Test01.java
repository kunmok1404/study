package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test01 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:xe", "study", "hard");
		
//		��� ���� 
		String sql = "insert into person values(person_seq.nextval, 'ronaldo', 'user00', 'ȣ����', 2000, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		
		con.close();
		System.out.println("����!");
	}
}








