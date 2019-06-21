<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지!</title>
</head>
<body>
	<%--template.jsp를 이곳으로 불러와서 적용시키는 코드 --%>
	
	<%--1. 정적 include 방식 : 코드를 복사하여 합치는 형태 --%>
	<%-- 	<%@ include file="/jsp/template.jsp" %> --%>
	
	<%-- 2. 동적 include 방식 : 따로 컴파일한 뒤 실행시 합치는 형태(가상) --%>
	<jsp:include page="/jsp/template.jsp"
	></jsp:include>
</body>
</html>