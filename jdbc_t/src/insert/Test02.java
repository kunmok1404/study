package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws Exception {
//		사용자에게 아이디 / 비밀번호 / 이름을 입력받아 추가
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.nextLine();
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		sc.close();
		
//		데이터베이스 처리
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:xe", "study", "hard");
		
		String sql = "insert into person values("
				+ "person_seq.nextval, '"+id+"', '"+pw+"', '"+name+"', 2000, sysdate)";
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		
		con.close();
		System.out.println("성공!");
	}
}



















