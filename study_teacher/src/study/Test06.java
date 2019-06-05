package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test06")
public class Test06 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		try {
//			입력
			int max = Integer.parseInt(req.getParameter("max"));

			if(max > 1) {
//				계산
				int total = 0;
				for (int i = 1; i <= max; i++) {
					total += i;
				}

//				출력
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/plain");
				resp.getWriter().println("합계 : "+total);
			}
			else {
//				resp.setCharacterEncoding("UTF-8");
//				resp.setContentType("text/plain");
//				resp.getWriter().println("계산이 불가능합니다");
				throw new Exception();
			}
		}
		catch(Exception e) {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			resp.getWriter().println("계산이 불가능합니다");
		}
	}
}
