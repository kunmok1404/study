package home.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;

@WebServlet(urlPatterns="/admin/delete.do")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("email");
			MemberDao dao = new MemberDao();
			dao.delete(email);
			response.sendRedirect(request.getContextPath() + "/admin/search.jsp");
			
		} catch (Exception e) {
			response.sendError(500);
			e.printStackTrace();
		}
	}
}
