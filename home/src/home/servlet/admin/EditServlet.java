package home.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

@WebServlet(urlPatterns="/admin/edit.do")
public class EditServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			MemberDto dto = new MemberDto();
			dto.setEmail(request.getParameter("email"));
			dto.setName(request.getParameter("name"));
			dto.setBirth(request.getParameter("birth"));
			dto.setPhone(request.getParameter("phone"));
			dto.setAnswer(request.getParameter("answer"));
			dto.setAuth(request.getParameter("auth"));
			MemberDao dao = new MemberDao();
			dao.updateUser(dto);
			
			response.sendRedirect("../admin/info.jsp?email=" + dto.getEmail());
			
		} catch (Exception e) {
			response.sendError(500);
			e.printStackTrace();
		}
	}
}
