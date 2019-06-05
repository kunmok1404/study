package study;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test05")
public class Test05 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		�Է� : start, finish �Ķ����
//		int start = Integer.parseInt(req.getParameter("start"));
		String a = req.getParameter("start");
		int start = Integer.parseInt(a);
		String b = req.getParameter("finish");
		int finish = Integer.parseInt(b);
		
//		��� : ǥ�� �ڹ� ��Ű���� ���� �� ��� ����
		Random r = new Random();
		int number = r.nextInt(finish - start + 1) + start;
		
//		���
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("��÷�� ���� "+number);
	}
}




