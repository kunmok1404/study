package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

@WebServlet(urlPatterns="/member/new_pw.do")
public class NewPwServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			MemberDto dto = new MemberDto();
			dto.setEmail(req.getParameter("email"));
			dto.setPw(req.getParameter("pw"));
			
			MemberDao dao = new MemberDao();
			dao.newPw(dto);
			resp.sendRedirect("new_pw_result.jsp");
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
