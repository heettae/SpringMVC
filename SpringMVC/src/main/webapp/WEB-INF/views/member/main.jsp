<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
	<h2><a href="/member/update"> 회원정보 수정</a> </h2>
	<h2><a href="/member/delete"> 회원탈퇴</a> </h2>
	<h2><a href="/board/list"> 게시판</a> </h2>
<%-- 	
	<%if(id!=null && id.equals("admin")){ %> 
	<h2><a href="/member/list"> 회원정보 목록</a> </h2>
	<%} %>
	 --%>
	 
	 <c:if test="${!empty id && id.equals('admin') }">
	 <h2><a href="/member/list"> 회원정보 목록</a> </h2>
	 </c:if>
	
</body>
</html>