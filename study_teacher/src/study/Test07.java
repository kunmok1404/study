package study;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test07")
public class Test07 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int len = Integer.parseInt(req.getParameter("len"));
		
		List<String> list = new ArrayList<>();
		for(char i='A'; i <= 'Z'; i++)	list.add(String.valueOf(i));
		for(char i='a'; i <= 'z'; i++)	list.add(String.valueOf(i));
		for(char i='0'; i <= '9'; i++)	list.add(String.valueOf(i));
		
		Random r = new Random();
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i < len; i++) {
			int index = r.nextInt(list.size());
//			resp.getWriter().print(list.get(index));
			buffer.append(list.get(index));
		}
		String npw = buffer.toString();
		resp.getWriter().println(npw);
	}
}






