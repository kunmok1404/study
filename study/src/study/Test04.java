package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/test04")
public class Test04 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 입력
			String type = req.getParameter("type");
			int amount = Integer.parseInt(req.getParameter("amount"));
			
			// 계산
			double total = 0;
			String result = null;
			switch(type) {
				case "krw" :
					result = "원화";
					total = amount / 1182.2;
					break;
				case "usd" :
					result = "달러";
					total = amount * 1182.2;
					break;
			}
			
//			if(type.equals("krw")) {
//				result = "원화";
//				total = amount * 1182.2;
//			} else if(type.equals("usd")) {
//				result = "달러";
//				total = amount / 1182.2;
//			} 
			
			// 출력
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			resp.getWriter().println("타입은 : " + result);
			resp.getWriter().println( amount + "원/달러는 " + total + "원/달러 입니다.");
		} catch (Exception e) {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			resp.getWriter().println("타입과 금액을 입력해주세요");
		}
	}
}
