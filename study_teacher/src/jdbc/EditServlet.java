package jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/edit.do")
public class EditServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력 : id, pw, npw
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String npw = req.getParameter("npw");
			
//			출력
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			
			PersonDao pdao = new PersonDao();
			if(pdao.login(id, pw)) {
				if(pw.equals(npw)) {
					resp.getWriter().println("똑같은 비밀번호로는 바꿀 수 없습니다");
				}
				else {
					PersonDto pdto = new PersonDto();
					pdto.setId(id);
					pdto.setPw(npw);
					pdao.edit(pdto);
					resp.getWriter().println("변경 완료");
				}
			}
			else {
				resp.getWriter().println("정보가 일치하지 않습니다");
			}
		}
		catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}





