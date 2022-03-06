<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>QNA Detail Page</h1>

	<h3>num : ${dto.num}</h3>
	<h3>title : ${dto.title}</h3>
	<h3>contents : ${dto.contents}</h3>

	<a href="./list">List</a>
	
	<a href="./update?num=${dto.num}">update</a>
	<a href="./delete?num=${dto.num}">DELETE</a>
</body>
</html>