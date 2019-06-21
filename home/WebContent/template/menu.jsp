<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	(주의) 템플릿 페이지는 다른 페이지에 불려가서 실행되므로 경로를 절대경로로 작성
	-- 프로젝트 명이 변경될 경우 모든 링크를 다 수정해야 하기 때문에
		context path(소속 경로) 를 구하는 방법을 알아야 함 
	- request.getContextPath()로 프로젝트의 루트 경로를 구할 수 있음
	- 절대경로 작성시 직접 쓰지 말고 해당 명령을 사용하는 것이 바람직
-->
	<%
		String email = (String)session.getAttribute("ok");
		String auth = (String)session.getAttribute("auth");
		boolean login = email != null;
	%>	
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<%-- 로그인 여부에 따라 메뉴를 구분하여 출력 --%>
				<% if(login) { %>
					<a href="<%=request.getContextPath() %>/index.jsp">메인화면</a>
					<a href="<%=request.getContextPath()%>/member/info.do">내정보</a>
					<a href="<%=request.getContextPath()%>/member/logout.jsp">로그아웃</a>
					<a href="<%=request.getContextPath()%>/board/list.jsp">게시판</a>
					
					<%if(auth.equals("관리자")) {%>
					[<a href="<%=request.getContextPath()%>/admin/search.jsp">회원 관리</a>]
					<%} %>
				<% } else { %>
					<a href="<%=request.getContextPath() %>/index.jsp">메인화면</a>
					<a href="<%=request.getContextPath() %>/member/regist.jsp">회원가입</a>
					<a href="<%=request.getContextPath() %>/member/login.jsp">로그인</a>
					<a href="<%=request.getContextPath()%>/board/list.jsp">게시판</a>
				<% } %>
			</div>
		</div>
	</nav>
	