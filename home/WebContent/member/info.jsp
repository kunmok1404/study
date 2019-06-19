<%@page import="beans.MemberDto"%>
<%@page import="beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	이 페이지는 "로그인된 사용자" 전용 페이지이므로 반드시 세션의 ok값이 필요
--%>

<%
	String email = (String)session.getAttribute("ok");
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.get(email);
%>
    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <h1><%=dto.getName() %> 님의 회원정보</h1>
    
    <table border="1" width="400">
    	<tbody>
    		<tr>
    			<th>회원번호</th>
    			<th><%=dto.getNo() %></th>
    		</tr>
    		<tr>
    			<th>이메일</th>
    			<th><%=dto.getEmail() %></th>
    		</tr>
    		<tr>
    			<th>이름</th>
    			<th><%=dto.getName() %></th>
    		</tr>
    		<tr>
    			<th>생일</th>
    			<th><%=dto.getBirth() %></th>
    		</tr>
    		<tr>
    			<th>전화번호</th>
    			<th><%=dto.getPhone() %></th>
    		</tr>
    		<tr>
    			<th>질문</th>
    			<th><%=dto.getQuestion() %></th>
    		</tr>
    		<tr>
    			<th>답변</th>
    			<th><%=dto.getAnswer() %></th>
    		</tr>
    		<tr>
    			<th>등록일</th>
    			<th><%=dto.getRegist() %></th>
    		</tr>
    		<tr>
    			<th>등급</th>
    			<th><%=dto.getAuth() %></th>
    		</tr>
    		<tr>
    			<th>최근접속일</th>
    			<th><%=dto.getRecent() %></th>
    		</tr>
    	</tbody>
    </table>
    
    <%-- 회원이 이용할 수 있는 기능들을 링크로 제공 --%>
    <h3><a href="check.jsp?go=<%=request.getContextPath() %>/member/new_pw.jsp?email=<%=email%>">비밀번호 변경</a></h3>
    <h3><a href="check.jsp?go=<%=request.getContextPath() %>/member/change_info.jsp?email=<%=email%>">개인정보 변경</a></h3>
    <h3><a href="check.jsp?go=<%=request.getContextPath() %>/member/delete.do">회원 탈퇴</a></h3>    
    
    <jsp:include page="/template/footer.jsp"></jsp:include>