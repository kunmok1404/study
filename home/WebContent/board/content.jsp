<%@page import="beans.CommentDto"%>
<%@page import="java.util.List"%>
<%@page import="beans.CommentDao"%>
<%@page import="beans.BoardDao"%>
<%@page import="beans.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String email = (String)session.getAttribute("ok");
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao dao = new BoardDao();
	dao.read(no);
	BoardDto bdto = dao.content(no);
	
	// 댓글 목록을 불러오는 코드
	CommentDao cdao = new CommentDao();
	List<CommentDto> list = cdao.get(no);
%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <h2>글쓰기</h2>
    <div align="center">
    	<table>
    		<tbody>
    			<tr>
    				<th>말머리</th>
    				<td><%= bdto.getHead()%></td>
    			</tr>
    			<tr>
    				<th>제목</th>
    				<td><%= bdto.getTitle()%></td>
    			</tr>
    			<tr>
    				<th>내용</th>
    				<td><%= bdto.getContent()%></td>
    			</tr>
    			<tr>
    				<th>작성자</th>
    				<td><%= bdto.getWriter()%></td>
    			</tr>
    			<tr>
    				<th>조회수</th>
    				<td><%= bdto.getRead()%></td>
    			</tr>
    			<%-- 댓글 목록 표시영역 --%>
    			<tr>
    				<td colspan="2">
    					<table width="100%">
    						<tbody>
    							<%-- 댓글 1개표시 영역 시작 --%>
    							<% for(CommentDto cdto : list){ %>
    							<tr>
    								<td width="90%">
    									<font color="blue" size="5">
    									<%= cdto.getWriter() %>
    									</font>
    									<%-- 댓글 작성자가 게시글 작성자라면 추가적으로 표시 --%>
    									<% if(cdto.getWriter().equals(bdto.getWriter())) { %>
    									<font color="red">(작성자)</font>
										<% } %>    									
    									<font color="gray">
    									<%= cdto.getWhen() %>
    									</font>
    									<br>
    									<%= cdto.getContent() %>
    									<hr>  		
    								</td>
    								<% if(cdto.getWriter().equals(email)){ %>  						
    								<td>
    									<a href="c_delete.do?no=<%=no %>&cno=<%=cdto.getNo()%>">삭제</a>
    								</td>
    								<% } %>
    							</tr>
    							<% } %>
    						</tbody>
    					</table>
    				</td>
    			</tr>
    			<%-- 댓글 입력 영역 --%>
    			<tr>
    				<td colspan="2">
    					<form action="comments.do?" method="post">
    						<input type="hidden" name="origin" value="<%=no %>">
    						<textarea name="content" rows="4" cols="90" placeholder="댓글 입력" required></textarea>
    						<input type="submit" value="등록">
    					</form>
    				</td>
    			</tr>
    			
    		</tbody>
    	</table><br>
    	<button><a href="list.jsp">목록</a></button>
    	<button><a href="write.jsp">글쓰기</a></button>
    	<button><a href="write.jsp?parent=<%=no%>">답글쓰기</a></button>
    	<button><a href="edit.jsp?no=<%=bdto.getNo()%>">수정</a></button>
    	<button><a href="delete.do?no=<%=bdto.getNo()%>">삭제</a></button>
    </div>    
    
    <jsp:include page="/template/footer.jsp"></jsp:include>
    
    <jsp:include page="/template/list_part.jsp"></jsp:include>