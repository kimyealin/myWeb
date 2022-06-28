<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//String message = request.getParameter("message");
%>
<jsp:useBean id="msg" class="tommy.web.sample.SimpleData"/>
<%-- SimpleData msg = new SimpleData(); 과 같음--%>
<jsp:setProperty property="message" name="msg"/>
<%-- msg.setMessage(?); --%>

<!-- 주의점 : 기본자료형, String -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>간단한 빈즈 프로그램 결과</h1>
<hr color="red"></hr><br><br>
<font size="5">
메세지 : <jsp:getProperty property="message" name="msg"/>
<%-- <%= message --%>
</font>

</body>
</html>