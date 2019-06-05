package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test01")
public class Test01 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
//		사용자 화면에 표시할 형식을 추가
		resp.setContentType("text/plain");
//		resp.setCharacterEncoding("EUC-KR");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println("뛟꿄흁핛");
		
		//코드 : 화면에 1부터 10까지 출력
		for(int i=1; i <= 10; i++) {
			//System.out.println(i);
			resp.getWriter().println(i);
		}
	}
	
}




