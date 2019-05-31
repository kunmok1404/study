package select;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test02 {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from person";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			int point = rs.getInt("point");
			String when = rs.getString("when");
//			Date when = rs.getDate("when");
			System.out.print(no+"\t");
			System.out.print(id+"\t");
			System.out.print(pw+"\t");
			System.out.print(name+"\t");
			System.out.print(point+"\t");
			System.out.print(when+"\t");
			System.out.println();
		}
		
		con.close();
	}
}






