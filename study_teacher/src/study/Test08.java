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
		
//		로또번호를 중복없이 추첨하여 정렬한 뒤 출력
//		오름차순 - ascending(asc)			낮은 값부터 
//		내림차순 - descending(desc) 	높은 값부터
//		번호순, 이름순, 성적순, 최신순, ...
		
		int[] lotto = new int[6];
//		lotto ----> [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ] 
		
//		중복없이 추첨
		Random r = new Random();
		for(int i=0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45) + 1;
			
//			중복 검사 코드
			for(int k=0; k < i; k++) {
				if(lotto[i] == lotto[k]) {
					i--;
					break;
				}
			}
		}
		
//		선택 정렬(selection - sort) = 최소값 or 최대값 위치찾기 / 교체(swap)
//		가장 작은 값을 앞쪽부터 채운다
		
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
		
//		출력
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		for(int i=0; i < lotto.length; i++) {
			resp.getWriter().println(lotto[i]);
		}
		
		
	}
}
