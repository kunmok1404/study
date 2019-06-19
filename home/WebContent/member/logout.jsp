<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	// 로그아웃 = 세션값 삭제 + 메인이동
    	session.removeAttribute("ok"); // 항목 삭제
 		// session.invalidate(); //전체 삭제
    	response.sendRedirect(request.getContextPath());
    %>