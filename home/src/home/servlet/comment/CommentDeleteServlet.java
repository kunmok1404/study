package home.servlet.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CommentDao;

@WebServlet(urlPatterns="/board/c_delete.do")
public class CommentDeleteServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String no = req.getParameter("no");
			int cno = Integer.parseInt(req.getParameter("cno"));
			
			CommentDao cdao = new CommentDao();
			cdao.delete(cno);
			
			resp.sendRedirect("content.jsp?no="+no);
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
		
	}
}
