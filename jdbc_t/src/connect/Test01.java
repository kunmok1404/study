package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		오라클 데이터베이스에 연결
//		[1] ojdbc6.jar에 있는 OracleDriver 를 로드
		Class.forName("oracle.jdbc.OracleDriver");
		
//		[2] 로그인 - 아이디 + 비밀번호 + 주소(IP,Port)
//		con에는 오라클 연결정보가 저장
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:xe", "study", "hard");
		
		
//		[3] 로그아웃(연결 종료)
		con.close();
		
		System.out.println("성공!");
	}
}







