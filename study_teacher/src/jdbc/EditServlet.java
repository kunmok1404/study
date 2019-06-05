package jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/edit.do")
public class EditServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			�Է� : id, pw, npw
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String npw = req.getParameter("npw");
			
//			���
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			
			PersonDao pdao = new PersonDao();
			if(pdao.login(id, pw)) {
				if(pw.equals(npw)) {
					resp.getWriter().println("�Ȱ��� ��й�ȣ�δ� �ٲ� �� �����ϴ�");
				}
				else {
					PersonDto pdto = new PersonDto();
					pdto.setId(id);
					pdto.setPw(npw);
					pdao.edit(pdto);
					resp.getWriter().println("���� �Ϸ�");
				}
			}
			else {
				resp.getWriter().println("������ ��ġ���� �ʽ��ϴ�");
			}
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}





