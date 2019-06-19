<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String email = request.getParameter("email");
%>

	<jsp:include page="/template/header.jsp"></jsp:include>
	
	<% if(email==null){ %>
		<h2>당신의 아이디는 존재하지 않습니다.</h2>
		<h3><a href="login.jsp">로그인</a></h3>
		<h3><a href="../index.jsp">메인화면</a></h3>
		<h3><a href="find_id.jsp">아이디 찾기</a></h3>
		<h3><a href="find_pw.jsp">비밀번호찾기</a></h3>
	<% } else { %>
		<h2>당신의 아이디는 <%=email%> 입니다.</h2>
		<h3><a href="login.jsp">로그인</a></h3>
		<h3><a href="../index.jsp">메인화면</a></h3>
		<h3><a href="find_id.jsp">아이디 찾기</a></h3>
		<h3><a href="find_pw.jsp">비밀번호찾기</a></h3>
	<% } %>
	
	<jsp:include page="/template/footer.jsp"></jsp:include>
