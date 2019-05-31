package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test03 {
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
				+ "person_seq.nextval, ?, ?, ?, 2000, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
//		실행 전 ? 에 대한 값을 설정 - 명령을 잘 고르면 따옴표도 자동 생성됨
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		
		ps.execute();
		
		con.close();
		System.out.println("성공!");
	}
}



















