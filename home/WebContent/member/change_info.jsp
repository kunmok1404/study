<%@page import="beans.MemberDao"%>
<%@page import="beans.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String email = (String)session.getAttribute("ok");
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.get(email);
%>

    <jsp:include page="/template/header.jsp"></jsp:include>
		
		<h2>개인정보 수정화면</h2>
		<div align="center">
		<form action="change_info.do" method="post">
		<table border="1" width="400">
    	<tbody>
    		<tr>
    			<th>이메일</th>
    			<th><%=dto.getEmail() %></th>
    		</tr>
    		<tr>
    			<th>이메일</th>
    			<th><input type="hidden" name="email" value="<%=dto.getEmail() %>"></th>
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
    			<th><input type="tel" name="phone" value="<%=dto.getPhone()%>"></th>
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
    			<th><input type="text" name="answer" value="<%=dto.getAnswer()%>"></th>
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
    		<tr>
    			<th></th>
    			<th><input type="submit" value="수정하기"></th>
    		</tr>
	    	</tbody>
	    </table>
	    </form>
		</div>
		
	<jsp:include page="/template/footer.jsp"></jsp:include>