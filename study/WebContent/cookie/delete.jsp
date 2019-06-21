<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	// 쿠키는 만들어서 써야함(new)
    	Cookie c = new Cookie("test","goodbye");
    
    	// 쿠키 정보 삭제할 때에는 만료시간을 0초 후로 설정(삭제 명령이 없음)
    	c.setMaxAge(0);
    
    	// 사용자에게 만들어진 쿠키를 전송
    	response.addCookie(c);
    %>