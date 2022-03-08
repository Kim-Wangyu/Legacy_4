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
<h1>${board} Detail Page</h1>

<h3>NoticeNum : ${dto.num}</h3>
<h3>NoticeTitle : ${dto.title}</h3>
<h3>NoticeContents : ${dto.contents}</h3>
<h3>NoticeWriter : ${dto.writer}</h3>
<h3>NoticeregDate : ${dto.regDate}</h3>
<h3>NoticeHit : ${dto.hit}</h3>

	<a href="./list">List</a>
	
	<a href="./update?num=${dto.num}">update</a>
	<a href="./delete?num=${dto.num}">DELETE</a>
	<a href="./reply?num=${dto.num}">Reply</a>

</body>
</html>