<%@page import="beans.MemberDto"%>
<%@page import="beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String email = request.getParameter("email");
	String pw = request.getParameter("pw");
%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <h2><%=email%> 님의 변경된 비밀번호 : <%=pw%></h2>
    
     <jsp:include page="/template/footer.jsp"></jsp:include>