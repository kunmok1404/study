package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test06 {
	public static void main(String[] args) throws Exception{
		String id = "test";
		
//		DB 처리
//		select * from person where id='test';
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from person where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
//		rs의 데이터 유무로 로그인 판정이 가능
		if(rs.next()) {
			System.out.println("이미 사용중인 아이디입니다.");
		}
		else {
			System.out.println("사용할 수 있는 아이디입니다.");
		}
		
		con.close();
	}
}







