<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

.aa{
	background-color:forestgreen;
	color:white;
	font-size:2rem;
}

.container{
	margin-top : 50px;
}

.list{
	width:100%;
}

.jumbotron{
	text-align:center;
	font-size:30px;
}

.bb{
	text-align:center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="jumbotron">메모 목록</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered list">
					<tbody>
						<tr>
							<td class="text-center aa">번호</td>
							<td class="text-center aa">작성자</td>
							<td class="text-center aa">제목</td>
							<td class="text-center aa">내용</td>
							<td class="text-center aa">작성일</td>
						</tr>
						<c:forEach var="item" items="${list}">
						<tr>
							<td class="text-center">${item.id}</td>
							<td class="text-center">${item.writer}</td>
							<td>${item.title}</td>
							<td>${item.content}</td>
							<td class="text-center">${item.regist_date}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<span class="bb">
					<a href="./" type="button" class="btn btn-success btn-lg">메인화면</a>
				</span>
			</div>
		</div>
	</div>
</body>
</html>