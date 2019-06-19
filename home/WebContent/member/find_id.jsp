<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <h2>아이디 찾기</h2>    
    <form action="find_id.do" method="post">
    	<input type="text" name="name" placeholder="이름" required>
    	<br><br>
    	<input type="date" name="birth" placeholder="생년월일" required>
    	<br><br>
    	<input type="text" name="phone" placeholder="전화번호" >
    	<br><br>
    	<input type="submit" value="찾기">
    </form>
    
 	<jsp:include page="/template/footer.jsp"></jsp:include>