<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] movieList = {"마녀2","토르","범죄의도시2"};
	request.setAttribute("movieList", movieList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>
<body>
최신 인기 영화 :
<ul>
	<c:forEach var="movie" items="${movieList }">
		<li>${movie }</li>
	</c:forEach>
</ul>
</body>
</html>