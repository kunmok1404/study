package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test06_1 {
	public static void main(String[] args) throws Exception{
		String id = "test";
		
//		DB 처리
//		select count(*) from person where id='test';
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select count(*) from person where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
//		rs는 무조건 있고, 그 안의 데이터 숫자가 얼마인가에 따라 다르게 처리
		rs.next();//다음 행으로 이동
//		int count = rs.getInt("count(*)");
		int count = rs.getInt(1);//첫번째 칸
		if(count > 0) {
			System.out.println("이미 사용중인 아이디입니다.");
		}
		else {
			System.out.println("사용할 수 있는 아이디입니다.");
		}
		
		con.close();
	}
}







