package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test01")
public class Test01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 화면에 표시할 형식을 추가
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println("한글나가냐?");
		
		for(int i = 1; i <= 10; i++) {
			resp.getWriter().println(i);
		}
	}
	
}
