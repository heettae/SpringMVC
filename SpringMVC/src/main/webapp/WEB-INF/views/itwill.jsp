<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>itwill.jsp</h1>
	
	${memberVO }
	
	<hr>
	REQUEST : ${requestScope.memberVO }<br>
	SESSION : ${sessionScope.memberVO }<br>
	APPLICATION : ${applicationScope.memberVO }
	
	<hr>
	${param.userid }<br>
	${param.userpw }<br>
	
</body>
</html>