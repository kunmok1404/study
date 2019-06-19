<%@page import="beans.BoardDao"%>
<%@page import="beans.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao dao = new BoardDao();
	BoardDto dto = dao.content(no);
%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <h2>글정보 수정</h2>
    <div align="center">
    	<form action="edit.do" method="post">
    	<input type="hidden" name="no" value="<%=dto.getNo()%>">
    	<table>
    		<tbody>
    			<tr>
    				<th>말머리</th>
    				<td><select name="head">
    					<option selected>정보</option>
    					<option>공부</option>
    					<option>유머</option>
    					<option>자유</option>
    				</select></td>
    			</tr>
    			<tr>
    				<th>제목</th>
    				<td><input type="text" name="title" value="<%= dto.getTitle()%>"></td>
    			</tr>
    			<tr>
    				<th>내용</th>
    				<td><input type="text" name="content" value="<%= dto.getContent()%>"></td>
    			</tr>
    			<tr>
    				<th>작성자</th>
    				<td><%= dto.getWriter()%></td>
    			</tr>
    			<tr>
    				<th>조회수</th>
    				<td><%= dto.getRead()%></td>
    			</tr>
    		</tbody>
    	</table>
    	<input type="submit" value="수정">
    	<button><a href="list.jsp">목록</a></button>
    	</form>
    	
    </div>    
    
    <jsp:include page="/template/footer.jsp"></jsp:include>