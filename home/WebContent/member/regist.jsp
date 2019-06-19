<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/template/header.jsp"></jsp:include>
	<div align="center">
	<h1>회원가입</h1>
		<form action="<%=request.getContextPath() %>/regist.do" method="post">
			<input type="text" name="name" placeholder="이름" required>*<br><br>
			<input type="email" name="email" placeholder="이메일" required>*<br><br>
			<input type="password" name="pw" placeholder="비밀번호" required>*<br><br>
			<input type="date" name="birth" placeholder="YYYYMMDD" required>*<br><br>
			<input type="text" name="phone" placeholder="전화번호"><br><br>
			<select name="question"required>
				<option value="친한친구이름" selected>당신의 제일 친한친구 이름은 무엇입니까?</option>
				<option value="고향">당신의 고향은 어디입니까?</option>
				<option value="좋아하는음식">당신이 제일 좋아하는 음식은 무엇입니까?</option>
				<option value="좋아하는색">당신이 제일 좋아하는 색깔은 무엇입니까?</option>
			</select>*
			<br><br>
			<input type="text" name="answer" placeholder="답변을 입력하세요." maxlength="30" required>*<br><br>
			<input type="submit" value="회원가입">
		</form>
	</div>
<jsp:include page="/template/footer.jsp"></jsp:include>