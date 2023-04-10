<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>main.jsp</h1>
	
	jsp표현식 : <%=session.getAttribute("id") %><br>
	el표현식 : ${sessionScope.id }<br>
	el표현식 : ${id }<br>
	
	<% 
	// JSP/MVC => 스프링 시큐리티
	String id = (String) session.getAttribute("id");
	if(id==null){
		//response.sendRedirect("/member/login");
	%>
	<input type="button" value="로그인" onclick="location.href = '/member/login'">

	<%} else {%>
	<input type="button" value="로그아웃" onclick="location.href = '/member/logout'">
	
	<% }%>
	
	<h2><a href="/member/info"> 회원정보 보기</a> </h2>
	
	
</body>
</html>