package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test02")
public class Test02 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		�������������� �Է�?
//		 - �ּҸ� ���ؼ� �����͸� ����(�Ķ����, parameter)
//		 - ��û ��ü(body)�� �����͸� ����
		
//		�̸� �ʿ��� �������� �̸��� ���� : q , r
		String q = req.getParameter("q");
		String r = req.getParameter("r");
		
//		����� ���� ���� : �ѱۼ���, ���ļ���
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
//		���
		resp.getWriter().println("q = "+q);
		resp.getWriter().println("r = "+r);
		
	}
}




