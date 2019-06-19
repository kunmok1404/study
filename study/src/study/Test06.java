package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/test06")
public class Test06 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		try {
			int max = Integer.parseInt(req.getParameter("max"));
			
			if(max > 1) {
				int total = 0;
				for(int i = 1; i <= max; i++) {
						total += i;
				}
				resp.getWriter().println("합계는 " + total);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			resp.getWriter().println("계산할 수 없습니다");
		}
		
	}
}
