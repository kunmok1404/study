package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test04")
public class Test04 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		try {
//			�Է� : �Ķ����
			String type = req.getParameter("type");//krw, usd
			double amount = Double.parseDouble(req.getParameter("amount"));
			
			switch(type) {
			case "krw": case "usd":
				break;
			default:
				throw new Exception();
			}
			
//			���
//			double result = amount / 1182.2 or amount * 1182.2;
			double result;
			String from, to;
			if(type.equals("krw")) {
				result = amount / 1182.2;
				from = "��";
				to = "�޷�";
			}
			else {
				result = amount * 1182.2;
				from = "�޷�";
				to = "��";
			}
//			���
			resp.getWriter().println(amount+" "+from+" �� "+result+" "+to+" �Դϴ�");
			
		}
		catch(Exception e) {
			resp.getWriter().println("�־��� ������ ����� �Ұ��մϴ�");
		}
	}
}





