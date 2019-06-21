<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <h1>${mdto.name} 님의 회원정보</h1>
    
    <table border="1" width="400">
    	<tbody>
    		<tr>
    			<th>회원번호</th>
    			<th>${mdto.no}</th>
    		</tr>
    		<tr>
    			<th>이메일</th>
    			<th>${mdto.email}</th>
    		</tr>
    		<tr>
    			<th>이름</th>
    			<th>${mdto.name}</th>
    		</tr>
    		<tr>
    			<th>생일</th>
    			<th>${mdto.birth}</th>
    		</tr>
    		<tr>
    			<th>전화번호</th>
    			<th>${mdto.phone}</th>
    		</tr>
    		<tr>
    			<th>질문</th>
    			<th>${mdto.question}</th>
    		</tr>
    		<tr>
    			<th>답변</th>
    			<th>${mdto.answer}</th>
    		</tr>
    		<tr>
    			<th>등록일</th>
    			<th>${mdto.regist}</th>
    		</tr>
    		<tr>
    			<th>등급</th>
    			<th>${mdto.auth}</th>
    		</tr>
    		<tr>
    			<th>최근접속일</th>
    			<th>${mdto.recent}</th>
    		</tr>
    	</tbody>
    </table>
    
    <%-- 회원이 이용할 수 있는 기능들을 링크로 제공 --%>
    <h3><a href="check.jsp?go=${pageContext.request.contextPath}/member/new_pw.jsp?email=${mdto.email}">비밀번호 변경</a></h3>
    <h3><a href="check.jsp?go=<%=request.getContextPath() %>/member/change_info.jsp?email=${mdto.email}">개인정보 변경</a></h3>
    <h3><a href="check.jsp?go=<%=request.getContextPath() %>/member/delete.do">회원 탈퇴</a></h3>    
    
    <jsp:include page="/template/footer.jsp"></jsp:include>