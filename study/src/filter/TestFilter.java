package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns="/cookie/*")
@WebFilter(urlPatterns= {
   "/html/a.html",
   "/html/div.html"
})
public class TestFilter implements Filter{

	// ServletRequest, ServletResponse는 HTTP시리즈의 부모클래스
	// FilterChain은 연결정보
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("테스트 필터!");
		
		// 통과하는 명령
		chain.doFilter(request, response);
		
		// 다른곳으로 이동시키는 명령
		// 다운캐스팅하여 사용
		HttpServletResponse resp = (HttpServletResponse)response; 
		resp.sendRedirect("/study/html/table04.html");
		
	}
	
}
