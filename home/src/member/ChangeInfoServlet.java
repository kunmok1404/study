package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

@WebServlet(urlPatterns="/member/change_info.do")
public class ChangeInfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			MemberDto dto = new MemberDto();
			dto.setEmail(req.getParameter("email"));
			dto.setPhone(req.getParameter("phone"));
			dto.setQuestion(req.getParameter("question"));
			dto.setAnswer(req.getParameter("answer"));
			
			MemberDao dao = new MemberDao();
			dao.updateInfo(dto);
			
			resp.sendRedirect("info.jsp");
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
