<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	// 쿠키 검색
    	Cookie[] array = request.getCookies();
    
    	String value = null;
    	if(array!=null) {
    		for(Cookie c : array){
    			if(c.getName().equals("test"))
    			//out.print("이름 : " + c.getName() + ", 값 : " + c.getValue());
    			value = c.getValue();
    			break;
    		}
    	}
    %>