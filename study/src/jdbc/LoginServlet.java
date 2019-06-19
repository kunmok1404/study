package jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.beans.PersonDao;

@WebServlet(urlPatterns ="/login.do")
public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		try {
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			PersonDao dao = new PersonDao();
			boolean login = dao.login(id,pw);
			
			if(login) {
				resp.getWriter().println("�α��� ����");
			} else {
				resp.getWriter().println("������ ��ġ���� �ʽ��ϴ�.");
			}
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
			
		}
	}
}
