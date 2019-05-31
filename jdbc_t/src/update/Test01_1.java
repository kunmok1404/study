package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test01_1 {
	public static void main(String[] args) throws Exception{
//		명령 2종류 -> 연결 ?번 , 전송 ?번
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.nextLine();
		
//		로그인 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from person where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		boolean login = rs.next();
		con.close();//DB 작업이 끝났으므로 연결 종료... 나중에 필요하면 재연결
		
		if(login) {
			System.out.println("변경할 비밀번호를 입력하세요");
			String npw = sc.nextLine();
			
			//재연결
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
			
			sql = "update person set pw=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, npw);
			ps.setString(2, id);
			ps.execute();
			System.out.println("비밀번호 변경이 완료되었습니다");
		}
		else {
			System.out.println("로그인 정보가 일치하지 않습니다");
		}
		
		con.close();
		sc.close();
	}
}





