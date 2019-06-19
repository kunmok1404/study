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

@WebServlet(urlPatterns ="/find.do")
public class FindServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
		
			PersonDao dao = new PersonDao();
			PersonDto dto = dao.find(Integer.parseInt(req.getParameter("no")));
			
			if(dto == null ) {
				resp.getWriter().println("존재하지 않습니다.");
			} else {
				resp.getWriter().print("<회원정보><br>");
				resp.getWriter().print("번호 : " + dto.getNo() +"<br>");
				resp.getWriter().print("아이디 : " + dto.getId()+"<br>");
				resp.getWriter().print("이름 : " + dto.getName()+"<br>");
				resp.getWriter().print("비밀번호 : " + dto.getPw()+"<br>");
				resp.getWriter().print("포인트 : " + dto.getPoint()+"<br>");
				resp.getWriter().println("가입일 : " + dto.getWhen()+"<br>");
			}
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
	
}
