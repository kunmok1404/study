<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <%-- error 파라미터 유무에 따라 오류메시지를 출력 --%>
   <% if(request.getParameterMap().containsKey("error")) { %> 
    	<h4>
    		<font color="red">
    			입력하신 정보에 해당하는 회원이 존재하지 않습니다.
    		</font>
    	</h4>
    <% } %>
    
    <h2>비밀번호 찾기</h2>
    <form action="find_pw.do" method="post">
    	<input type="text" name="email" placeholder="이메일" required><br><br>
    	<input type="text" name="question" placeholder="비밀번호확인질문" required><br><br>
    	<input type="text" name="answer" placeholder="비밀번호확인답변" required><br><br>
    	<input type="submit" value="찾기">
    </form>
    
    <jsp:include page="/template/footer.jsp"></jsp:include>
    