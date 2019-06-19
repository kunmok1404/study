package jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.beans.PersonDao;
import jdbc.beans.PersonDto;

@WebServlet(urlPatterns="/regist.do")
public class RegistServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 데이터 수신 전에 요청의 모든 데이터를 UTF-8형식으로 복구
			req.setCharacterEncoding("UTF-8");
			
			PersonDto dto = new PersonDto();
			dto.setName(req.getParameter("name"));
			dto.setId(req.getParameter("id"));
			dto.setPw(req.getParameter("pw"));
			
			PersonDao dao = new PersonDao();
			dao.regist(dto);
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			resp.getWriter().println("회원가입이 완료되었습니다.");
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
