package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		����Ŭ �����ͺ��̽��� ����
//		[1] ojdbc6.jar�� �ִ� OracleDriver �� �ε�
		Class.forName("oracle.jdbc.OracleDriver");
		
//		[2] �α��� - ���̵� + ��й�ȣ + �ּ�(IP,Port)
//		con���� ����Ŭ ���������� ����
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:xe", "study", "hard");
		
		
//		[3] �α׾ƿ�(���� ����)
		con.close();
		
		System.out.println("����!");
	}
}







