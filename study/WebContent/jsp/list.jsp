<%@page import="jdbc.beans.PersonDao"%>
<%@page import="jdbc.beans.PersonDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<% PersonDao dao = new PersonDao(); %>
<% List<PersonDto> list = dao.list(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>person list</title>
</head>
<body>
	<div align="center">
		<h1>person 데이터 목록</h1>
		<table border="1" width="700">
			<thead>
				<tr>
					<th>NO</th>
					<th>이름</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>포인트</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<% for(PersonDto d : list ) { %>
				<tr>
					<td><% out.print(d.getNo()); %></td>
					<td><% out.print(d.getName()); %></td>
					<td><% out.print(d.getId()); %></td>
					<td><% out.print(d.getPw()); %></td>
					<!-- out.print()대신 아래의 식을 이용가능(표현식, EL태그) -->
					<td><%= d.getPoint() %></td>
					<td><%= d.getWhen() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		
	</div>
</body>
</html>