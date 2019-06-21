<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	// 쿠키는 만들어서 써야함(new)
    	Cookie c = new Cookie("test","goodbye");
    
    	// 쿠키 정보 설정
    	c.setMaxAge(5);
    
    	// 사용자에게 만들어진 쿠키를 전송
    	response.addCookie(c);
    %>