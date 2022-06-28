<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
	private int numOne = 0;
	public void jspInit(){
		System.out.println("jspInit() 호출됨");
	}
	
	public void jspDestroy(){
		System.out.println("jspDestroy() 호출됨");
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Life Cycle</title>
</head>
<body>
<%
	int numTwo = 0;
	numOne++; //새로고침할때마다 증가
	numTwo++; //새로고침할때마다 초기화
%>

<ul>
	<li>Number One : <%=numOne %></li>
	<li>Number Two : <%=numTwo %></li>
</ul>

</body>
</html>