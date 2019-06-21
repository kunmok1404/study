<%@page import="jdbc.beans.FilesDto"%>
<%@page import="java.util.List"%>
<%@page import="jdbc.beans.FilesDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	FilesDao fdao = new FilesDao();
    	List<FilesDto> list = fdao.list();
    %>
    
    <% for(FilesDto fdto : list) { %>
    	<h1><%= fdto.getUploadName() %>
    	(<%=fdto.getLen() %>)
    	<!-- 직접 링크에 접속하면 다운로드가 수행된다. -->
    	<a href="download.jsp?savename=<%=fdto.getSaveName()%>">
    	<img src="../image/download.png" width="50" height="50">
    	</a></h1>
    	
    	<!-- img 태그로 링크걸면 이미지가 표시된다. -->
    	<img src="../image/download.png" width="50" height="50">
    	
    <% } %>