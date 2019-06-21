package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardDao;
import beans.BoardDto;

@WebServlet(urlPatterns="/board/write.do")
public class WriteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String email = (String)req.getSession().getAttribute("ok");
			BoardDao dao = new BoardDao();
			int sequence = dao.getseq();
		
			BoardDto dto = new BoardDto();
			dto.setNo(sequence);
			dto.setHead(req.getParameter("head"));
			dto.setTitle(req.getParameter("title"));
			dto.setContent(req.getParameter("content"));
			
			// parent가 있다면 dto에 추가(답글일 경우)
			if(req.getParameterMap().containsKey("parent")) {
				dto.setParent(Integer.parseInt(req.getParameter("parent")));
			}
			dto.setWriter(email);
			int no = dao.write(dto);
			
			
			resp.sendRedirect("content.jsp?no="+ no);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
		
	}
	
}
