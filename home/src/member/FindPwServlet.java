package member;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

@WebServlet(urlPatterns="/member/find_pw.do")
public class FindPwServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			MemberDto dto = new MemberDto();
			dto.setEmail(req.getParameter("email"));
			dto.setQuestion(req.getParameter("question"));
			dto.setAnswer(req.getParameter("answer"));
			
			MemberDao dao = new MemberDao();
			boolean result = dao.findPw(dto);
			
			if(result) {
				resp.sendRedirect("new_pw.jsp?email=" + dto.getEmail());
			} else {
				resp.sendRedirect("find_pw.jsp?error");
			}
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
		
	}
}
