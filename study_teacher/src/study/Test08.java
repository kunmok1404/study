package study;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test08")
public class Test08 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		�ζǹ�ȣ�� �ߺ����� ��÷�Ͽ� ������ �� ���
//		�������� - ascending(asc)			���� ������ 
//		�������� - descending(desc) 	���� ������
//		��ȣ��, �̸���, ������, �ֽż�, ...
		
		int[] lotto = new int[6];
//		lotto ----> [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ] 
		
//		�ߺ����� ��÷
		Random r = new Random();
		for(int i=0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45) + 1;
			
//			�ߺ� �˻� �ڵ�
			for(int k=0; k < i; k++) {
				if(lotto[i] == lotto[k]) {
					i--;
					break;
				}
			}
		}
		
//		���� ����(selection - sort) = �ּҰ� or �ִ밪 ��ġã�� / ��ü(swap)
//		���� ���� ���� ���ʺ��� ä���
		
		for(int i=0; i < lotto.length - 1; i++) {
			int min = i;
			for(int k=i+1; k < lotto.length; k++) {
				if(lotto[min] > lotto[k]) {
					min = k;
				}
			}
			
			int tmp = lotto[i];
			lotto[i] = lotto[min];
			lotto[min] = tmp;
		}
		
//		���
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		for(int i=0; i < lotto.length; i++) {
			resp.getWriter().println(lotto[i]);
		}
		
		
	}
}
