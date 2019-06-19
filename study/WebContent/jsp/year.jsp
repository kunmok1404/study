<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<select>
		<% 
			int current = Calendar.getInstance().get(Calendar.YEAR);
		%>
		<% for(int year = current; year >= 1900; year--) { %>
		<!-- jsp에서는 resp.getWriter() 대신 out을 사용 - 출력용 내장 객체 -->
		<option>
			<% out.print(year); %>
		</option>
		<% } %>
	</select>
	년
	
		<!-- 월, 일 선택창을 만들어보세요. -->
	<select>
		<% for(int month = 1; month <= 12; month++) {%>
		<option>
			<% out.print(month); %>
		</option>
		<%  } %>
	</select>
	월
	
	<select>
		<% for(int day = 1; day <= 31; day++) { %>
		<option>
			<% out.print(day); %>
		</option>
		<%  } %>
	</select>
	일
	
</body>
</html>