<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tommy.web.actiontag.Customer" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="customer" class="tommy.web.actiontag.Customer" scope="page"/>
<jsp:setProperty property="*" name="customer"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입정보</title>
</head>
<body>
<ul>
	<li>이름 :
	<jsp:getProperty property="name" name="customer"/></li>
	<li>이메일 :
	<jsp:getProperty property="email" name="customer"/></li>
	<li>전화 :
	<jsp:getProperty property="phone" name="customer"/></li>
</ul>
</body>
</html>