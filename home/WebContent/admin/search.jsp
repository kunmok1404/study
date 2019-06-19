<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.MemberDao"%>
<%@page import="beans.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	// type 유무에 따라 검색진행
	List<MemberDto> list;
	MemberDao dao = new MemberDao();
	if(type==null){
		list = null;
	} else {
		list = dao.search(type, keyword);		
	}
%> 

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <h2>회원 검색(관리자)</h2>
    <div align="center">
    <form action="search.jsp" method="get">
    	<select name="type">
    		<option value="email" <%=(type!=null&&type.equals("email"))?"selected":"" %>>이메일</option>
    		<option value="name" <%=(type!=null&&type.equals("name"))?"selected":"" %>>이름</option>
    		<option value="birth" <%=(type!=null&&type.equals("birth"))?"selected":"" %>>생년월일</option>
    		<option value="phone" <%=(type!=null&&type.equals("phone"))?"selected":"" %>>전화번호</option>
    		<option value="auth" <%=(type!=null&&type.equals("auth"))?"selected":"" %>>권한</option>
    	</select>
    	<input type="text" name="keyword" placeholder="검색어" value="<%=keyword==null?"":keyword %>" required>
    	<input type="submit" value="검색"> 
    </form>
    </div>
    
    <hr>
    
    <%if(list==null || list.isEmpty()){ %>
    <h3>검색 결과가 존재하지 않습니다.</h3>
    <%} else { %>
    <%--결과가 출력될 테이블 --%>
    <div align="center">
    	<table border="1" width="800">
    		<thead>
    			<tr>
    				<th>번호</th>
    				<th>이메일</th>
    				<th>이름</th>
    				<th>생년월일</th>
    				<th>전화번호</th>
    				<th>가입일</th>
    				<th>권한</th>
    				<th>관리메뉴</th>
    			</tr>
    		</thead>
    		<tbody>
    		   <%for(MemberDto dto : list){ %>
    			<tr>
    				<td><%=dto.getNo() %></td>
    				<td><%=dto.getEmail() %></td>
    				<td><%=dto.getName() %></td>
    				<td><%=dto.getBirth() %></td>
    				<td><%=dto.getPhone() %></td>
    				<td><%=dto.getRegist() %></td>
    				<td><%=dto.getAuth() %></td>
    				<td>
    					<%--상세보기 --%>
    					<a href="info.jsp?email=<%=dto.getEmail()%>"><img src="../image/view.png" width="20" height="20"></a>
    					<%--수정 --%>
    					<a href="edit.jsp?email=<%=dto.getEmail()%>"><img src="../image/edit.png" width="20" height="20"></a>
    					<%--탈퇴 --%>
    					<a href="../member/check.jsp?go=<%=request.getContextPath() %>/admin/delete.do?email=<%=dto.getEmail()%>"><img src="../image/delete.png" width="20" height="20"></a>
    				</td>
    			</tr>
    			<%} %>
    		</tbody>
    	</table>
    </div>
    <%} %>
    
    <jsp:include page="/template/footer.jsp"></jsp:include>