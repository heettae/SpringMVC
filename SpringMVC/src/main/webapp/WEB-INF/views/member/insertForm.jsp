<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> insertForm.jsp </h1>
	
	<fieldset>
		<!-- <form action="./insertPro" method="post"> -->
		<!-- <form action="/member/insertPro" method="post"> --> <!-- 이렇게 작성하는 방법을 권장함(코드상 이해) -->
		<form action="/member/insert" method="post"> <!-- String 버전으로 배우면서 변경함 -->
			아이디 : <input type="text" name= "userid"><br>
			비밀번호 : <input type="password" name= "userpw"><br>
			이름 : <input type="text" name= "username"><br>
			이메일 : <input type="text" name= "useremail"><br>
			<input type="submit" value="회원가입">
		</form>
	</fieldset>
</body>
</html>