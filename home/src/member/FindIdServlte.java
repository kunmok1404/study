package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

@WebServlet(urlPatterns="/member/find_id.do")
public class FindIdServlte extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			MemberDto dto = new MemberDto();
			dto.setName(req.getParameter("name"));
			dto.setBirth(req.getParameter("birth"));
			dto.setPhone(req.getParameter("phone"));
			
			MemberDao dao = new MemberDao();
			String email = dao.findId(dto);
			
			if(email == null) {
				resp.sendRedirect("find_id_result.jsp");
			} else {
				resp.sendRedirect("find_id_result.jsp?email=" + email);
			}
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
