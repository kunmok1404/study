<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="/template/header.jsp"></jsp:include>
    
    <h2>글쓰기</h2>
    <div align="center">
    <form action="write.do" method="post">
    	<table>
    		<tbody>
    			<tr>
    				<th>말머리</th>
    				<td><select name="head">
    					<option selected>정보</option>
    					<option>공부</option>
    					<option>유머</option>
    					<option>자유</option>
    				</select></td>
    			</tr>
    			<tr>
    				<th>제목</th>
    				<td><input type="text" name="title" placeholder="제목을 입력하세요." required></td>
    			</tr>
    			<tr>
    				<th>내용</th>
    				<td><textarea rows="15" cols="70" name="content"></textarea></td>
    			</tr>
    		</tbody>
    	</table>
    	<button><a href="list.jsp">목록</a></button>
    	<input type="submit" value="확인">
    </form>
    </div>    
    
    <jsp:include page="/template/footer.jsp"></jsp:include>