package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

@WebServlet(urlPatterns="/member/check.do")
public class CheckServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 이메일(세션), 비밀번호(파라미터)
			String email = (String)req.getSession().getAttribute("ok");
			String pw = req.getParameter("pw");
			String go = req.getParameter("go");
			MemberDto dto = new MemberDto();
			dto.setEmail(email);
			dto.setPw(pw);
			
			MemberDao dao = new MemberDao();
			boolean result = dao.login(dto);
			
			if(result) {
				resp.sendRedirect(go);
			} else {
				resp.sendRedirect("check.jsp?error&go="+go);
			}
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
		
	}
}
