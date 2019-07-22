<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
@font-face {
    font-family: Binggrae;
    src: url("../../font/Binggrae.ttf");
}

*{
    box-sizing: border-box;
    font-family: Binggrae;
} 

.jumbotron{
	font-size:40px;
}

</style>
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center">
			상품 관리 시스템 v0.1
		</div>
		<div class="row text-center">
			<div>
				<a href="regist" class="btn btn-lg btn-primary">상품 등록</a>
			</div>
		</div><hr>
		<div class="row text-center">
			<div>
				<a href="list" class="btn btn-lg btn-success">상품 목록</a>
			</div>
		</div>
	</div>

</body>
</html>