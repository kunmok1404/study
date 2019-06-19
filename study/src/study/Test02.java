package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test02")
public class Test02 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// 웹페이지에서의 입력
		// - 주소를 통해서 데이터를 전달(파라미터, parameter)
		// - 요청 몸체(body)에 데이터를 전달
		
		// 미리 필요한 데이터의 이름을 정의 : q, r
		String q = req.getParameter("q");
		String r = req.getParameter("r");
		
		// 출력을 위한 설정 : 한글 설정, 형식 설정
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		// 출력
		resp.getWriter().println("q =" + q);
		resp.getWriter().println("r =" + r);
	}
	
}
