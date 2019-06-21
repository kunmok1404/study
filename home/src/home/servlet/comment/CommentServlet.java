package home.servlet.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CommentDao;
import beans.CommentDto;

@WebServlet(urlPatterns="/board/comments.do")
public class CommentServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String email = (String)req.getSession().getAttribute("ok");
			String content = req.getParameter("content");
			int origin = Integer.parseInt(req.getParameter("origin"));
			
			CommentDto dto = new CommentDto();
			dto.setContent(content);
			dto.setOrigin(origin);
			dto.setWriter(email);
			
			CommentDao dao = new CommentDao();
			dao.comm_regist(dto);
			
			resp.sendRedirect("content.jsp?no="+ origin);
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
		
	}
}
