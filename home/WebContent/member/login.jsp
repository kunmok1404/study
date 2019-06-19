<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Cookie[] array = request.getCookies();
	String value=null;
	if(array!=null){
		for(Cookie c : array){
			if(c.getName().equals("saveId")){
				value = c.getValue();
				break;
			}
		}
	}
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>로그인</h2>
	<form action="login.do" method="post">
		<%if(value!=null){ %>
		<input type = "text" name="email" placeholder="이메일" value="<%=value%>" required><br><br>
		<%} else { %>
		<input type = "text" name="email" placeholder="이메일" required><br><br>
		<%} %>
		<input type = "password" name="pw" placeholder="비밀번호" required><br><br>
		<%if(value!=null){ %>
		<input type ="checkbox" name="remember" value="saveId" checked>아이디 저장<br><br>
		<%} else { %>
		<input type ="checkbox" name="remember" value="saveId">아이디 저장<br><br>
		<%} %>
		<input type = "submit" value="로그인"><br><br>
		<a href="find_id.jsp">아이디가 기억나지 않아요.</a><br><br>
		<a href="find_pw.jsp">비밀번호가 기억나지 않아요.</a>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>