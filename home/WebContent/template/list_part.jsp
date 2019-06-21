<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="home.util.Paging"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="beans.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.BoardDao"%>
<%
	Paging p = new Paging(request);
	p.calculate();
%>

	<div align="center">
	<h2>게시판 목록</h2><br>
		
		<div class="row">
		<div class="offset-md-5 col-md-5">
		<form class="form-inline" style="text-align:center;" action="list.jsp" method="post">
			<select name ="select" class="mr-sm-2">
				<option value="head" <%=request.getParameter("select")!=null && request.getParameter("select").equals("head")?"selected":"" %>>말머리</option>
				<option value="writer" <%=request.getParameter("select")!=null && request.getParameter("select").equals("writer")?"selected":"" %>>작성자</option>
				<option value="title" <%=request.getParameter("select")!=null && request.getParameter("select").equals("title")?"selected":"" %>>제목</option>
			</select>
			<input class="form-control mr-sm-2" type="search" name="keyword" placeholder="검색어 입력" value="<%=p.getKeyword()!=null?p.getKeyword():""%>">
			<button class="btn btn-success" type="submit">Search</button>
		</form>
		</div>
		</div><br>
	
		<table border="1">
			<thead style="color:green">
				<tr>
					<td>말머리</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회</td>
					<td>team</td>
					<td>parent</td>
					<td>depth</td>
				</tr>
			</thead>
			<tbody>
					<%for(BoardDto dto : p.getList()){ %>
					<tr>
						<%-- 말머리는 있을때에만 []를 붙여서 출력 --%>
						<td><%=dto.getHead() %></td>
						<td>
						<%-- 차수(depth)만큼 띄어쓰기 진행 --%>
						<% for(int i =0; i < dto.getDepth(); i++) { %>
							&nbsp;&nbsp;
						<% } %>
						
						<%-- 답변글만 아이콘 추가 --%>
						<% if(dto.getDepth() > 0) { %>
							<img src="../image/reply.png" width="30" height="20">
						<% } %>
						
						<a href="content.jsp?no=<%=dto.getNo()%>"><%=dto.getTitle() %></a></td>
						<td><%=dto.getWriter() %></td>
						<td><%=dto.getWhen() %></td>
						<td><%=dto.getRead() %></td>
						<td><%=dto.getTeam() %></td>
						<td><%=dto.getParent() %></td>
						<td><%=dto.getDepth() %></td>
					</tr>
					<%} %>
			</tbody>
		</table>
		
	</div>
	
	<br>
	
	<h4>
		<% if(!p.isFirstBlock()) { %>
		<a href="list.jsp?<%=p.getPrevBlock()%>">&lt;&lt;</a>
		<% } %>
		
		<% if(!p.isFirstPage()) { %>
		<a href="list.jsp?<%=p.getPrevPage()%>">&lt;</a>
		<% } %>
		
		<%for(int i=p.getStartBlock(); i <=p.getEndBlock(); i++){ %>
		<%if(p.isCurrentPage(i)) {%>
			<font color="red"><%=i %></font>
		<%}else{ %>
			<a href="list.jsp?<%=p.getPage(i)%>"><%=i %></a>
			<%} %>
		<%} %>
		
		<% if(!p.isLastPage()) { %>
		<a href="list.jsp?<%=p.getNextPage()%>">&gt;</a>
		<% } %>
		
		<% if(!p.isLastBlock()) { %>
		<a href="list.jsp?<%=p.getNextBlock()%>">&gt;&gt;</a>
		<% } %>
	</h4>
	
	<button><a href="write.jsp">글쓰기</a></button>