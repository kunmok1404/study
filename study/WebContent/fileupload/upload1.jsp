<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 업로드 페이지 -->
<!-- 
	get방식일 경우 파일은 이름만 전송됨
	post방식일 경우 2가지 전송 모드가 존재
	-기본적으로 url encoding방식을 사용(get방식과 동일)
	-이름은 한개인데 보낼 내용은 여러개라서 전송이 불가능
	-multipart/form-data 방식을 사용
		구분선을 이용하여 여러개의 정보를 보내는 방식(파일명,파일유형,파일내용)
 -->
	<h1>기본방식</h1>
    <form action="upload2.jsp" method="post">
    	<input type="file" name="f" multiple>
    	<input type="submit" value="업로드">
    </form>
    
    <h1>multipart방식</h1>
     <form action="upload3.jsp" method="post" enctype="multipart/form-data">
    	<input type="file" name="f" multiple>
    	<input type="submit" value="업로드">
    </form>