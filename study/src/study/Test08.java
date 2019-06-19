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

@WebServlet(urlPatterns = "/test08")
public class Test08 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		Random r = new Random();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < 6; i++) {
			int lotto = r.nextInt(45) + 1;
			if(list.contains(lotto)) {
				i--;
			} else {
				list.add(lotto);
			}
		}
		
		for(int i : list) {
			resp.getWriter().println(i);
		}
		
	}
}
