package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

@WebServlet(urlPatterns="/regist.do")
public class RegistServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String pw = req.getParameter("pw");
			String birth = req.getParameter("birth");
			String phone = req.getParameter("phone");
			String question = req.getParameter("question");
			String answer = req.getParameter("answer");
			
			MemberDao  dao = new MemberDao();
			MemberDto dto = new MemberDto();
			
			dto.setEmail(email);
			dto.setName(name);
			dto.setBirth(birth);
			dto.setPw(pw);
			dto.setPhone(phone);
			dto.setQuestion(question);
			dto.setAnswer(answer);
			
			dao.regist(dto);
		
			resp.sendRedirect( req.getContextPath() + "/member/regist_result.jsp");
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}  
		
	}
	
}
