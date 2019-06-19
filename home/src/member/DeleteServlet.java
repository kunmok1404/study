package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;

@WebServlet(urlPatterns="/member/delete.do")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String email = (String)req.getSession().getAttribute("ok");
			MemberDao dao = new MemberDao();
			dao.delete(email);
			req.getSession().removeAttribute("ok");
			resp.sendRedirect("goodbye.jsp");		
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
