package jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.beans.PersonDao;
import jdbc.beans.PersonDto;

@WebServlet(urlPatterns = "/list.do")
public class ListServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		try {
			PersonDao dao = new PersonDao();  
			
			List<PersonDto> list = dao.list();
			
			for(PersonDto d : list) {
				resp.getWriter().println(d.getNo() + "<br>");
				resp.getWriter().println(d.getId()+ "<br>");
				resp.getWriter().println(d.getName()+ "<br>");
				resp.getWriter().println(d.getPoint()+ "<br>");
				resp.getWriter().println(d.getPw()+ "<br>");
				resp.getWriter().println(d.getWhen()+ "<br>");
			}
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
		
	}
}
