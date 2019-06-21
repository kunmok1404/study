<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- 수신페이지 -->
    
    <%
    	// 이 코드들은 url encoding방식으로 전송되는 데이터를 수신
    	// key : value = 1:1
    	
    	// 1개만 받을때
    	//String f = request.getParameter("f");
    
    	// 여러개 받을 때
    	request.setCharacterEncoding("UTF-8");
    	String[] arr = request.getParameterValues("f");
    %>
    
    <h2>arr= <%= Arrays.toString(arr) %></h2>