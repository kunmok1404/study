package jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/list.do")
public class ListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력 : 없음
//			계산
			PersonDao dao = new PersonDao();
			List<PersonDto> list = dao.list();
			
//			출력
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
//			resp.getWriter().println(list);
			for(PersonDto pdto : list) {
//				resp.getWriter().println(pdto);
				resp.getWriter().print(pdto.getNo() + " / ");
				resp.getWriter().print(pdto.getId() + " / ");
				resp.getWriter().print(pdto.getPw() + " / ");
				resp.getWriter().print(pdto.getName() + " / ");
				resp.getWriter().print(pdto.getPoint() + " / ");
				resp.getWriter().println(pdto.getWhen());
			}
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}







