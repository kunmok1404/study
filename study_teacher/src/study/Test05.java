package study;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test05")
public class Test05 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		입력 : start, finish 파라미터
//		int start = Integer.parseInt(req.getParameter("start"));
		String a = req.getParameter("start");
		int start = Integer.parseInt(a);
		String b = req.getParameter("finish");
		int finish = Integer.parseInt(b);
		
//		계산 : 표준 자바 패키지는 전부 다 사용 가능
		Random r = new Random();
		int number = r.nextInt(finish - start + 1) + start;
		
//		출력
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("추첨된 수는 "+number);
	}
}




