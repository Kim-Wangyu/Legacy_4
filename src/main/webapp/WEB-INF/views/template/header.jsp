<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="./resources/css/header.css">
<link rel="stylesheet" href="./resources/css/reset.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+sharp"  rel="stylesheet">
<header class="header">
	<nav class="d1">
		<ul>
			<li><a href="/s1/">HOME</a></li>
			<li><a href="/s1/notice/list">notice</a></li>
			<li><a href="/s1/qna/list">QnA</a></li>
			<li><a href="/s1/bankbook/list">Product</a></li>
		</ul>
	</nav>

	<nav class="r1">
		<ul>
			<c:choose>
				<c:when test="${not empty member}">
					<li><a href="/s1/member/mypage">mypage</a></li>
					<li><a href="/s1/member/logout">로그아웃</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/s1/member/login">로그인<span class="material-icons icon">
login
</span></a></li>
					<li><a href="/s1/member/join">회원가입<span class="material-icons icon">
person_add
</span></a></li>
				</c:otherwise>
			</c:choose>
		</ul>

	</nav>



</header>