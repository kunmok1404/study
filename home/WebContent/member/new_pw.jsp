<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String email=request.getParameter("email");
%>

<%-- 이메일은 자동첨부처리 --%>
 <jsp:include page="/template/header.jsp"></jsp:include>
 
 <h1>비밀번호 변경</h1>
 <form action="new_pw.do" method="post">
 	<input type="hidden" name="email" value="<%=email%>"><br><br>
 	<input type="password" name="pw" placeholder="신규 비밀번호" required><br><br>
 	<input type="submit" value="변경하기">
 </form>
 
 <jsp:include page="/template/footer.jsp"></jsp:include>