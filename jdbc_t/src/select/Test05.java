package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) throws Exception{
//		검색어 입력받기		
		Scanner sc = new Scanner(System.in);
		System.out.println("찾으실 아이디 입력하세요");
		String key = sc.nextLine();
		sc.close();
		
//		데이터베이스 처리
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
			System.out.println("아이디 : "+rs.getString("id"));
		}
		
		con.close();
		
	}
}








