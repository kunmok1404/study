<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

     <h1>a = <%= application.getAttribute("a") %></h1>
     <h1>b = <%= session.getAttribute("b") %></h1>
     <h1>c = <%= request.getAttribute("c") %></h1>
     <h1>d = <%= pageContext.getAttribute("d") %></h1>