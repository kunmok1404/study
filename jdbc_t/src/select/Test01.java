package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01 {
	public static void main(String[] args) throws Exception{
//		select * from food 를 자바로 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from food";
		PreparedStatement ps = con.prepareStatement(sql);
//		ps.execute();//실행은 되지만 결과집합에 접근이 불가
		ResultSet rs = ps.executeQuery();//실행 후 결과집합 정보 반환
		
//		명령 : rs.next() , rs.getString() , rs.getInt()
		while(rs.next()) {
			System.out.println(rs.getString("type"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("price"));
		}
		
		con.close();
		System.out.println("성공!");
	}
}






