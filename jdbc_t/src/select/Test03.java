package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) throws Exception {
//		사용자가 입력한 분류에 해당하는 데이터를 FOOD 테이블에서 조회
		Scanner sc = new Scanner(System.in);
		System.out.println("분류를 입력하세요");
		String type = sc.nextLine();
		sc.close();
		
//		데이터베이스 처리
//		select * from food where type=?
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from food where type=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, type);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					rs.getString("name")+"("+rs.getInt("price")+"원)");
		}
		
		con.close();
		
	}
}







