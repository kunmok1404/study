<%@page import="beans.MemberDto"%>
<%@page import="beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String email = request.getParameter("email");
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.get(email);
%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
     <h1><%=dto.getName() %> 님의 회원정보</h1>
		<div align="center">
		<form action="change_info.do" method="post">
		<table border="1" width="400">
    	<tbody>
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
    			<th><%=dto.getPhone()%></th>
    		</tr>
    		<tr>
    			<th>질문</th>
    			<th>
    			<select name="question"required>
				<option value="친한친구이름" selected>당신의 제일 친한친구 이름은 무엇입니까?</option>
				<option value="고향">당신의 고향은 어디입니까?</option>
				<option value="좋아하는음식">당신이 제일 좋아하는 음식은 무엇입니까?</option>
				<option value="좋아하는색">당신이 제일 좋아하는 색깔은 무엇입니까?</option>
				</select>*
				</th>
    		</tr>
    		<tr>
    			<th>답변</th>
    			<th><%=dto.getAnswer()%></th>
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
	    </form>
		</div>
    
     <h3><a href="change_pw.do?email=<%=dto.getEmail()%>">비밀번호 변경</a></h3>
     <h3><a href="">개인정보 변경</a></h3>
   	 <h3><a href="">회원 탈퇴</a></h3>    
   	 
    <jsp:include page="/template/footer.jsp"></jsp:include>