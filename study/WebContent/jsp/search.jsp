<%@page import="java.util.List"%>
<%@page import="jdbc.beans.PersonDto"%>
<%@page import="jdbc.beans.PersonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	PersonDao dao = new PersonDao(); 
	String key = request.getParameter("key"); 
	if(key==null) key ="";
	List<PersonDto> list = dao.search(key); 
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<div align="center">
		<h1>회원 목록</h1>
		<div align="center">
		<form action="">
			<input type="search" name = "key" value="<%out.print(key);%>" placeholder="검색할 아이디 입력" size="30">
			<input type="submit" value="검색">
		</form>
		</div>
		<br><br>
		<table border="1" width="700">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>포인트</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<% for(PersonDto dto : list) { %>
				<tr>
					<td><%= dto.getNo() %></td>
					<td><%= dto.getName()%></td>
					<td><%= dto.getId()%></td>
					<td><%= dto.getPw()%></td>
					<td><%= dto.getPoint()%></td>
					<td><%= dto.getWhen()%></td>
				</tr>
				<% } %>
			</tbody>
		</table>	
	</div>
</body>
</html>