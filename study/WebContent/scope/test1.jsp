<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	// JSP에서는 기본 저장 영역이 page 단위로 구현
    	String first = "짜장면";
    
    	// 기본 영역을 뛰어넘고 싶다면 "내장 저장소"를 사용
    	// pageContext, request, session, application
    	// -Map<String, Object> 형태의 저장소
    	// 설정 : setAttribute(), 추출 : getAttribute()
    	
    	application.setAttribute("a", 10);
    	session.setAttribute("b", 20);
    	request.setAttribute("c", 30);
    	pageContext.setAttribute("d", 40);
    %>
    
    <h1><%= first %></h1>
    <h1>a = <%= application.getAttribute("a") %></h1>
    <h1>b = <%= session.getAttribute("b") %></h1>
    <h1>c = <%= request.getAttribute("c") %></h1>
    <h1>d = <%= pageContext.getAttribute("d") %></h1>