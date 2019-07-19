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

.tt{
	height:200px;
	width:80%;
	margin:auto;
}

.jumbotron{
	text-align:center;
	font-size:30px;
}

.writer{
	background-color:#265aad;
	color:white;
	font-size:15px;
	vertical-align:center !important;
	padding:auto;
}

.table > tbody > tr > td{
	vertical-align : center !important;
}

.qq{
	text-align:center;
	padding:10px;
}
</style>
</head>
<body>
	<div class="container">
	<div class="jumbotron">메모 등록</div>
		<div class="row qq">
			<form action="write" method="post">
			<table class="table table-bordered tt">
				<tbody>
					<tr>
						<td class="writer">작성자</td>
						<td class="mt-3"><input type="text" name="writer" class="form-control mt-3" placeholder="이름을 입력하세요" required></td>
					</tr>
					<tr>
						<td class="writer">제목</td>
						<td><input type="text" name="title" class="form-control" placeholder="제목을 입력하세요" required></td>
					</tr>
					<tr>
						<td class="writer">내용</td>
						<td><textarea rows="5" class="form-control" name="content" placeholder="내용을 입력하세요" required></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="등록" class="form-control btn btn-primary"></td>
					</tr>
				</tbody>
			</table>
			</form><br>
			<span class="bb">
					<a href="./" type="button" class="btn btn-success btn-lg">메인화면</a>
			</span>
		</div>
	</div>
</body>
</html>