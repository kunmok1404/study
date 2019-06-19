package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardDao;
import beans.BoardDto;
import beans.MemberDto;

@WebServlet(urlPatterns="/board/edit.do")
public class EditServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BoardDto dto = new BoardDto();
			dto.setNo(Integer.parseInt(req.getParameter("no")));
			dto.setHead(req.getParameter("head"));
			dto.setTitle(req.getParameter("title"));
			dto.setContent(req.getParameter("content"));
			BoardDao dao = new BoardDao();
			dao.edit(dto);
			
			resp.sendRedirect("list.jsp");
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
