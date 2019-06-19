package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns= {
		"/member/logout.jsp",
		"/member/info.jsp",
		"/member/check.jsp",
		"/member/check.do",
		"/member/change_info.jsp",
		"/member/change_info.do",
		"/member/delete.do",
		"/member/goodbye.jsp",
		"/board/*",
		"/admin/*"
}, filterName="order2")
public class LoginFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		if(req.getSession().getAttribute("ok")!=null) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath()+"/member/login.jsp");
		}
		
	}
}
