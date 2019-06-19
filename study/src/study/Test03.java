package study;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test03")
public class Test03 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
	 
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			
//			String year = req.getParameter("year");
//			int born = Integer.parseInt(year);
			int year = Integer.parseInt(req.getParameter("year"));
			
			int current = Calendar.getInstance().get(Calendar.YEAR);
			int age = current - year + 1;
			
			int price;
			if(age >= 20 && age <65) 
				price = 1250;
			else if(age >= 14 && age <20)
				
				price = 720;
			else if(age >= 14 && age <20)
				price = 450;
			else 
				price = 0;
			
			resp.getWriter().println("당신의 나이는 " + age +"살 입니다.<br>");
			resp.getWriter().println("지하철 요금은 " + price + "원 입니다.");
			
		} catch (Exception e) {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			resp.getWriter().println("year에 출생년도를 설정하세요");
		}
	}
}
