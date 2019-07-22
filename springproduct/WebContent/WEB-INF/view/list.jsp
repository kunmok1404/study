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
		<div class="jumbotron">상품 목록</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered list">
					<tbody>
						<tr>
							<td class="text-center aa">번호</td>
							<td class="text-center aa">상품명</td>
							<td class="text-center aa">카테고리</td>
							<td class="text-center aa">이미지</td>
							<td class="text-center aa">가격</td>
						</tr>
						<c:forEach var="item" items="${list}">
						<tr>
							<td class="text-center">${item.no}</td>
							<td class="text-center"><a href="detail?no=${item.no}">${item.name}</a></td>
							<td>${item.type}</td>
							<c:if test="${item.type eq 'keyboard'}">
							<td><img src="res/image/keyboard.png"></td>
							</c:if>
							<c:if test="${item.type eq 'mouse'}">
							<td><img src="res/image/mouse.png"></td>
							</c:if>
							<td class="text-center">${item.price}</td>
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