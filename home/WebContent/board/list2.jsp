<%@page import="java.net.URLEncoder"%>
<%@page import="beans.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int pno;
	try{
		pno = Integer.parseInt(request.getParameter("pno"));
		if(pno<=0) throw new Exception();
	} catch(Exception e){
		pno = 1;
	}
	int psize = 10; // 1페이지에 표시할 글 개수
	// rownum 계산
	int end = pno * psize;
	int start = end-(psize-1);
	
	// 하단 네비게이션 부분을 계산(총 게시글 수를 이용한 페이지 수 계산)
	// 공식 : 페이지수 = (게시글수 + 페이지크기 -1) / 페이지크기
	String type = request.getParameter("select");
	String keyword = request.getParameter("search");
	BoardDao dao = new BoardDao();
	int count = dao.getCount(type, keyword);
	int pageCount = (count + psize - 1) / psize;
	
	int bsize = 10; // 1페이지에 표시할 링크 개수
	int startBlock = (pno-1)/bsize*bsize + 1;
	int endBlock = startBlock + (bsize-1);
	// 번호 넘어감 방지
	if(endBlock > pageCount){
		endBlock = pageCount;
	}

	List<BoardDto> list;  
	if(type != null && type!=null) {
		list = dao.search(type,keyword,start,end);
	} else {
		list = dao.list(start,end);
	}
	
	// 검색어 유지를 위해 검색일 때와 아닐 때의 첨부되는 파라미터 처리
	// 목록 : 검색어 처리 x
	// 검색 : &type=???&keyword=??? 형태의 파라미터를 생성
	boolean search = type!=null && keyword!=null;
	String query;
	if(search) {
		String tmp = URLEncoder.encode(type, "UTF-8");
		query = "&type=" + tmp + "&keyword=" + keyword;
	} else {
		query ="";
	}
%>

<jsp:include page="/template/header.jsp"></jsp:include>
  
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
			<input class="form-control mr-sm-2" type="search" name="search" placeholder="검색어 입력" value="<%=keyword!=null?keyword:""%>">
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
				</tr>
			</thead>
			<tbody>
					<%for(BoardDto dto : list){ %>
					<tr>
						<td><%=dto.getHead() %></td>
						<td><a href="content.jsp?no=<%=dto.getNo()%>"><%=dto.getTitle() %></a></td>
						<td><%=dto.getWriter() %></td>
						<td><%=dto.getWhen() %></td>
						<td><%=dto.getRead() %></td>
					</tr>
					<%} %>
			</tbody>
		</table>
	</div>
	
	<br>
	
	<h4>
		<% if(startBlock > 1) { %>
		<a href="list.jsp?pno=<%=startBlock-1%>">&lt;&lt;</a>
		<% } %>
		
		<% if(pno > 1) { %>
		<a href="list.jsp?pno=<%=pno-1%>">&lt;</a>
		<% } %>
		
		<%for(int i=startBlock; i <=endBlock; i++){ %>
		<%if(i==pno) {%>
			<font color="red"><%=i %></font>
		<%}else{ %>
			<a href="list.jsp?pno=<%=i %>"><%=i %></a>
			<%} %>
		<%} %>
		
		<% if(pno < pageCount ) { %>
		<a href="list.jsp?pno=<%=pno+1 %>">&gt;</a>
		<% } %>
		
		<% if(endBlock < pageCount) { %>
		<a href="list.jsp?pno=<%=endBlock+1%>">&gt;&gt;</a>
		<% } %>
	</h4>
	
	<button><a href="write.jsp">글쓰기</a></button>

<jsp:include page="/template/footer.jsp"></jsp:include>