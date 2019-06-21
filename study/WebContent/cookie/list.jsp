<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	// 쿠키 목록 출력
    	Cookie[] array = request.getCookies();
    
    	// 쿠키 개수? array.length
    	// 확장 반복문 사용 가능
    	// 한개도 없으면 array= null;
    	if(array!=null) {
    		for(Cookie c : array){
    			out.print("이름 : " + c.getName() + ", 값 : " + c.getValue());
    			out.print("<br>");
    		}
    	}
    %>