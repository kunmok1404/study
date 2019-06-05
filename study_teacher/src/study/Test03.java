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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력
//			String y = req.getParameter("year");
//			int year = Integer.parseInt(y);
			int year = Integer.parseInt(req.getParameter("year"));
			
//			계산
//			int current = 2019;
			int current = Calendar.getInstance().get(Calendar.YEAR);
			int age = current - year + 1;
			
//			int price = 1250 or 720 or 450 or 0;
			int price;
			if(age >= 20 && age < 65)			
				price = 1250;
			else if(age >= 14 && age < 20)		
				price = 720;
			else if(age >= 8 && age < 14)		
				price = 450;
			else						
				price = 0;
			
//			출력
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			
			resp.getWriter().println("당신의 나이 : "+age+"세");
			resp.getWriter().println("지하철 요금 : "+price+"원");
		}
		catch(Exception e) {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			resp.getWriter().println("year에 출생년도를 설정하세요");
		}
	}
}



