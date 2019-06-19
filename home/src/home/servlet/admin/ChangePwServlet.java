package home.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;
import home.util.StringGenerator;

@WebServlet(urlPatterns="/admin/change_pw.do")
public class ChangePwServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String email = req.getParameter("email");
			
			MemberDto dto = new MemberDto();
			dto.setEmail(email);
			dto.setPw(StringGenerator.random(10));
			
			MemberDao dao = new MemberDao();
			dao.newPw(dto);
						
			resp.sendRedirect("change_pw.jsp?email="+dto.getEmail()+"&pw="+dto.getPw());
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
