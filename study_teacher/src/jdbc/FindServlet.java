package jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/find.do")
public class FindServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			�Է� : no(ȸ����ȣ)
			int no = Integer.parseInt(req.getParameter("no"));
			
//			��� : �Է����� ����� ������ ����(int -> PersonDto)
			PersonDao pdao = new PersonDao();
			PersonDto pdto = pdao.find(no);
			
//			��� : ȸ������(PersonDto)
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			if(pdto == null) {
				resp.getWriter().println("�������� �ʴ� ȸ���Դϴ�");
			}
			else {
				resp.getWriter().println("<ȸ������>");
				resp.getWriter().println("��ȣ : "+pdto.getNo());
				resp.getWriter().println("���̵� : "+pdto.getId());
				resp.getWriter().println("��й�ȣ : "+pdto.getPw());
				resp.getWriter().println("�̸� : "+pdto.getName());
				resp.getWriter().println("����Ʈ : "+pdto.getPoint());
				resp.getWriter().println("������ : "+pdto.getWhen());
			}
		}catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}





