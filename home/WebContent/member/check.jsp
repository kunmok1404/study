<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
	로그인 된 유저가 한번더 인증할때 사용
 --%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <%-- error 파라미터 유무에 따라 오류메시지를 출력 --%>
   <% if(request.getParameterMap().containsKey("error")) { %> 
    	<h4>
    		<font color="red">
    			비밀번호가 맞지 않습니다.
    		</font>
    	</h4>
    <% } %>
    
    <h2>비밀번호 확인</h2>
    <form action="check.do" method="post">
    	<%-- 목적지 정보인 go파라미터를 다음 페이지로 전송 --%>
    	<input type="hidden" name="go" value="<%=request.getParameter("go") %>">
    	<input type="password" name="pw" placeholder="현재 비밀번호" required>
    	<input type="submit" value="확인">
    </form>
    
     
    
    <jsp:include page="/template/footer.jsp"></jsp:include>