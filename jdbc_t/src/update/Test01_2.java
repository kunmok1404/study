package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test01_2 {
//	로그인 메소드
	public static boolean login(String id, String pw) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "select * from person where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		boolean login = rs.next();
		con.close();
		
		return login;
	}
//	비밀번호 변경 메소드
	public static void change(String id, String npw) throws Exception{
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "hard");
		
		String sql = "update person set pw=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, npw);
		ps.setString(2, id);
		ps.execute();
		con.close();
	}
	
	public static void main(String[] args) throws Exception{
//		명령 2종류 -> 연결 ?번 , 전송 ?번
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.nextLine();
		
//		로그인 처리
		if(login(id, pw)) {
			System.out.println("변경할 비밀번호를 입력하세요");
			String npw = sc.nextLine();
			
			//재연결
			change(id, npw);
			System.out.println("비밀번호 변경이 완료되었습니다");
		}
		else {
			System.out.println("로그인 정보가 일치하지 않습니다");
		}
		
		sc.close();
	}
}





