package study;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test05")
public class Test05 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		try {
			// 입력
			int start = Integer.parseInt(req.getParameter("start"));
			int finish = Integer.parseInt(req.getParameter("finish"));
			
			// 계산
			Random r = new Random();
			int random = r.nextInt(finish - start + 1) + start;
			
		   // 출력		
			resp.getWriter().println("랜덤 숫자는 " + random + "입니다.");
		} catch (Exception e) {
			resp.getWriter().println("결과를 출력할 수 없습니다.");
		}
		
	}
}
