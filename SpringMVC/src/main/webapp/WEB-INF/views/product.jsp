<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>product.jsp</h1>
	
	<!-- 전달정보 저장 el표현식 -->
	${vo } <hr>
	상품명 : ${vo.name } <br>
	상품가격 : ${vo.price }<br>
	
	<hr>
	${productVO }<br>
	상품명 : ${productVO.name } <br>
	상품가격 : ${productVO.price }<br>
	
</body>
</html>