package jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/find.do")
public class FindServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력 : no(회원번호)
			int no = Integer.parseInt(req.getParameter("no"));
			
//			계산 : 입력으로 출력을 만들어내는 과정(int -> PersonDto)
			PersonDao pdao = new PersonDao();
			PersonDto pdto = pdao.find(no);
			
//			출력 : 회원정보(PersonDto)
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
			if(pdto == null) {
				resp.getWriter().println("존재하지 않는 회원입니다");
			}
			else {
				resp.getWriter().println("<회원정보>");
				resp.getWriter().println("번호 : "+pdto.getNo());
				resp.getWriter().println("아이디 : "+pdto.getId());
				resp.getWriter().println("비밀번호 : "+pdto.getPw());
				resp.getWriter().println("이름 : "+pdto.getName());
				resp.getWriter().println("포인트 : "+pdto.getPoint());
				resp.getWriter().println("가입일 : "+pdto.getWhen());
			}
		}catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}





