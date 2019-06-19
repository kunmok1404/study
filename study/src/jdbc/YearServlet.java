package jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/year.do")
public class YearServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿에서도 HTML 태그 사용이 가능
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		resp.getWriter().println("<select>");
		for(int year = 2019; year >= 1900; year--) {
			//resp.getWriter().println("<option>2019</option>");
			resp.getWriter().print("<option>");
			resp.getWriter().print(year);
			resp.getWriter().print("</option>");
		}
		resp.getWriter().println("</select>");
	}
}
