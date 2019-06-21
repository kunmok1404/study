<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="jdbc.beans.FilesDto"%>
<%@page import="jdbc.beans.FilesDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	// savename에 따른 파일 다운로드 처리를 구현(서블릿도 코드 동일)
    	// [1] 파라미터를 받는다(savename)
    	// [2] savename을 이용하여 파일정보를 불러온다.
    	// [3] 불러온 파일을 실제로 읽는다.
    	// [4] 읽어온 파일을 response를 이용하여 사용자에게 전송한다.
    	// -전송형태 : application/octet-stream
    	// [1] 
    	String savename = request.getParameter("savename");
    	// [2]
    	FilesDao fdao = new FilesDao();
    	FilesDto fdto = fdao.get(savename);
    	
    	// response 초기화(과거는 잊어라... 넌 application/octet-stream이야)
    	response.reset();
    	
    	// 헤더 설정 :	 response.setHeader("항목", "값");
    	//response.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
    	response.setHeader("Content-Type", "image/png; charset=UTF-8");
    	response.setHeader("Content-Disposition", "attachment; filename=" + fdto.getSendName());
    	response.setHeader("Content-Length", String.valueOf(fdto.getLen()));
    	response.setHeader("Content-Description", "부연설명");
    	
    	// [3], [4] 
    	File target = new File("D:\\upload\\", fdto.getSaveName());
    	
    	try(
    	InputStream in = new FileInputStream(target);
    	OutputStream send = response.getOutputStream();
    	) {
    	// in 에서 읽은것을 send로 전송
    	byte[] buffer = new byte[1024];
    	
    	while(true){
    		int size = in.read(buffer); // buffer에 저장하고 실제 개수를 size에 저장
    		if(size== -1) break; // EOF
        	send.write(buffer,0,size); // buffer의 내용을 0부터 size개 출력
    		}
     	}
    %>
    
    
    
    
    
    
    
    
    
    
    
    
    