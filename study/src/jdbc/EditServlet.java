package jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.beans.PersonDao;
import jdbc.beans.PersonDto;

@WebServlet(urlPatterns ="/edit.do")
public class EditServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String npw = req.getParameter("npw");
			
			PersonDao dao = new PersonDao();
			
			if(dao.login(id, pw)) { 
				PersonDto dto = new PersonDto();
				dto.setId(id);
				dto.setPw(npw);
				dao.edit(dto);;
				resp.getWriter().println("������ �Ϸ�Ǿ����ϴ�.");
			} else {
				resp.getWriter().println("�α��� ������ ��ġ���� �ʽ��ϴ�.");
			}
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
