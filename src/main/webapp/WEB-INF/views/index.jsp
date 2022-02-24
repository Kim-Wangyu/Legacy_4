<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./template/header_css.jsp"></c:import>

</head>
<body>
	<c:import url="./template/header.jsp"></c:import>

	<h1 align="center">Index Page</h1>

	<h3 align="right">${member.name}님
		환영합니다 <span class="material-icons-outlined"> account_circle </span>

	</h3>

	<div align="right">
		<c:if test="${not empty member}">
			<a href="./member/mypage">Mypage</a>
			<a href="./member/logout">Logout</a>
		</c:if>
		<c:if test="${empty member}">
			<a class="my" href="./member/login">Login</a>
			<a href="./member/join">Join</a>
		</c:if>
	</div>

	<P align="right">The time on the server is ${serverTime}.</P>
</body>
</html>