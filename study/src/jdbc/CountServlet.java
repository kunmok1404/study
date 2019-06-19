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
		// person 테이블의 데이터 개수를 출력
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
			resp.getWriter().println("데이터 개수 : " + count);
		} catch(Exception e) {
			// 예외 발생시 사용자에게 500 상태번호를 전달해야 함
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}