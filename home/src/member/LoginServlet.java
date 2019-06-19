package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

@WebServlet(urlPatterns="/member/login.do")
public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			MemberDto dto = new MemberDto();
			dto.setEmail(req.getParameter("email"));
			dto.setPw(req.getParameter("pw"));
			
			String remember = req.getParameter("remember");			
			Cookie c = new Cookie("saveId", req.getParameter("email"));
		
			MemberDao dao = new MemberDao();
			boolean result = dao.login(dto);
			
			if(result) {
				if(remember != null) {
					c.setMaxAge(7*24*60*60);
					resp.addCookie(c);
				} else {
					c.setMaxAge(0);
					resp.addCookie(c);
				}
				req.getSession().setAttribute("ok", dto.getEmail());				
				// email을 이용해서 권한을 획득한 뒤 세션에 추가
				MemberDto find = dao.get(dto.getEmail());
				req.getSession().setAttribute("auth", find.getAuth());
				
				dao.recent(dto.getEmail());
				resp.sendRedirect(req.getContextPath());
			} else {
				resp.sendRedirect(req.getContextPath() + "/member/login_fail.jsp");
			}
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
		
	}
}
