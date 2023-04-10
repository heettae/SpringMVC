<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> info.jsp </h1>
	
	${id } <br>
	
	아이디 : ${memberVO.userid } <br>
	비밀번호 : ${memberVO.userpw } <br>
	이름 : ${memberVO.username } <br>
	이메일 : ${memberVO.useremail } <br>
</body>
</html>