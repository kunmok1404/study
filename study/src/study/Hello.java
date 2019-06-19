package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 동적 처리를 위해서는 프로그래밍 코드가 필요
// 외부에서 접속하기 위한 주소도 필요
@WebServlet(urlPatterns="/hello")
public class Hello extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Hello world~~!!");	
	}
}
