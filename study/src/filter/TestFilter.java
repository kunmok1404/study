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

	// ServletRequest, ServletResponse�� HTTP�ø����� �θ�Ŭ����
	// FilterChain�� ��������
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("�׽�Ʈ ����!");
		
		// ����ϴ� ���
		chain.doFilter(request, response);
		
		// �ٸ������� �̵���Ű�� ���
		// �ٿ�ĳ�����Ͽ� ���
		HttpServletResponse resp = (HttpServletResponse)response; 
		resp.sendRedirect("/study/html/table04.html");
		
	}
	
}
