package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/count.do")
public class CountServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// person ���̺��� ������ ������ ���
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","hard");
			String sql = "select count(*) from person";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			
			con.close();
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			resp.getWriter().println("������ ���� : " + count);
		} catch(Exception e) {
			// ���� �߻��� ����ڿ��� 500 ���¹�ȣ�� �����ؾ� ��
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}