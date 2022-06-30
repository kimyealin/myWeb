<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="vo" class="tommy.web.jstl.MemberVO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>
<body>
<c:set target="${vo }" property="name" value="기매링"/>
<c:set target="${vo }" property="email">ling@nate.com</c:set>
<c:set var="age" value="28"/>
<c:set target="${vo }" property="age" value="${age }"/>
<h3>회원정보</h3>
<ul>
	<li>이름 : ${vo.name }</li>
	<li>메일 : ${vo.email }</li>
	<li>나이 : ${vo.age }</li>
</ul>
</body>
</html>