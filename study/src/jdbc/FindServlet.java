package jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.beans.PersonDao;
import jdbc.beans.PersonDto;

@WebServlet(urlPatterns ="/find.do")
public class FindServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
		
			PersonDao dao = new PersonDao();
			PersonDto dto = dao.find(Integer.parseInt(req.getParameter("no")));
			
			if(dto == null ) {
				resp.getWriter().println("�������� �ʽ��ϴ�.");
			} else {
				resp.getWriter().print("<ȸ������><br>");
				resp.getWriter().print("��ȣ : " + dto.getNo() +"<br>");
				resp.getWriter().print("���̵� : " + dto.getId()+"<br>");
				resp.getWriter().print("�̸� : " + dto.getName()+"<br>");
				resp.getWriter().print("��й�ȣ : " + dto.getPw()+"<br>");
				resp.getWriter().print("����Ʈ : " + dto.getPoint()+"<br>");
				resp.getWriter().println("������ : " + dto.getWhen()+"<br>");
			}
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
	
}
