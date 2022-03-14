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

<h3>Num : ${dto.num}</h3>
<h3>Title : ${dto.title}</h3>
<h3>Contents : ${dto.contents}</h3>
<h3>Writer : ${dto.writer}</h3>
<h3>regDate : ${dto.regDate}</h3>
<h3>Hit : ${dto.hit}</h3>

<div>
	<c:forEach items="${dto.fileDTOs}" var="f">
		<!-- <a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a>   클릭해서 보기     -->
		<a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a>
	
	</c:forEach>
</div>

	<a href="./list">List</a>
	
	<a href="./update?num=${dto.num}">update</a>
	<a href="./delete?num=${dto.num}">DELETE</a>
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
</body>
</html>