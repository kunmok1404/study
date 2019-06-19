<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width", initial-scale="1.0">
	<title>홈페이지</title>
	<link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
	<!-- A grey horizontal navbar that becomes vertical on small screens -->
	<nav class="navbar navbar-expand-sm bg-light">
	
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="#">Link 1</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="#">Link 2</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="#">Link 3</a>
	    </li>
	  </ul>
	
	</nav>
	
	<!-- Grey with black text -->
<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">Active</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link</a>
    </li>
    <li class="nav-item">
      <a class="nav-link disabled" href="#">Disabled</a>
    </li>
  </ul>
</nav>

<!-- Black with white text -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">...</nav>

<!-- Blue with white text -->
<nav class="navbar navbar-expand-sm bg-primary navbar-dark">...</nav>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <form class="form-inline" action="/action_page.php">
    <input class="form-control mr-sm-2" type="text" placeholder="Search">
    <button class="btn btn-success" type="submit">Search</button>
  </form>
</nav>

<form method="get" action="/save.php">
  찾으실 검색어를 입력하세요.<br />
  <input type="text" name="keyword" />
​​​​​​​  <button type="submit">SEARCH</button>
</form>

  <form class="form-inline" action="/action_page.php">
    <input class="form-control mr-sm-2" type="text" placeholder="Search">
    <button class="btn btn-success" type="submit">Search</button>
  </form>
  
  <table class="table table-striped table-bordered table-hover table-condensed">
  	<thead>
  		<tr>
  			<td>#</td>
  			<td>FirstName</td>
  			<td>LastName</td>
  			<td>UserName</td>
  		</tr>
  	</thead>
  	<tbody>
  		<tr class="success">
  			<td>1</td>
  			<td>Mark</td>
  			<td>Otto</td>
  			<td>@mdo</td>
  		</tr>
  		<tr>
  			<td>2</td>
  			<td>Mark</td>
  			<td>Otto</td>
  			<td>@mdo</td>
  		</tr>
  		<tr>
  			<td>3</td>
  			<td>Mark</td>
  			<td>Otto</td>
  			<td>@mdo</td>
  		</tr>
  	</tbody>
  </table>
  
</body>
</html>