package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02 {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:xe", "study", "hard");
		
		//연결 ~ 종료 사이에 원하는 명령을 작성한 뒤 실행 처리
		//명령 전송 도구 : PreparedStatement
		//(주의) ; 을 명령에 사용하면 에러
		String sql = "create table test1(value number primary key)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.execute();
		
		con.close();
		System.out.println("성공!");
	}
}






