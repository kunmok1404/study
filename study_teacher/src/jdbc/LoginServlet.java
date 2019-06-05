package jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력 : id, pw
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
//			계산
			PersonDao pdao = new PersonDao();
			boolean result = pdao.login(id, pw);
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			if(result)
				resp.getWriter().println("로그인 성공");
			else
				resp.getWriter().println("정보가 일치하지 않습니다");
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}





