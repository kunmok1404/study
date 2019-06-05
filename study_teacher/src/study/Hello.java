package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//���� ó���� ���ؼ��� ���α׷��� �ڵ尡 �ʿ�
//�ܺο��� �����ϱ� ���� �ּҵ� �ʿ�
@WebServlet(urlPatterns="/hello")
public class Hello extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		//req : ������� �ֹ� ������ ������ ���Ե� ��ü
		//resp : ����ڿ��� ������ ����� ������ ���Ե� ��ü
		
		//�ڵ�
		//System.out.println("Hello~!");
		resp.getWriter().println("Hello~!");
	}
}


