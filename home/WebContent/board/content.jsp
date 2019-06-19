<%@page import="beans.BoardDao"%>
<%@page import="beans.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao dao = new BoardDao();
	dao.read(no);
	BoardDto dto = dao.content(no);
%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <h2>글쓰기</h2>
    <div align="center">
    	<table>
    		<tbody>
    			<tr>
    				<th>말머리</th>
    				<td><%= dto.getHead()%></td>
    			</tr>
    			<tr>
    				<th>제목</th>
    				<td><%= dto.getTitle()%></td>
    			</tr>
    			<tr>
    				<th>내용</th>
    				<td><%= dto.getContent()%></td>
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
    	</table><br>
    	<button><a href="list.jsp">목록</a></button>
    	<button><a href="edit.jsp?no=<%=dto.getNo()%>">수정</a></button>
    	<button><a href="delete.do?no=<%=dto.getNo()%>">삭제</a></button>
    </div>    
    
    <jsp:include page="/template/footer.jsp"></jsp:include>