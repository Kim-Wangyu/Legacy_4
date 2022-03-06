<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Qna Update Page</h1>
	
	<form action="./update" method="POST">
		<input type="hidden" name="num" value="${dto.num}" readonly="readonly">
		title<input type="text" name="title" value="${dto.title}">
		contents <textarea name="contents" rows="" cols="">${dto.contents}</textarea>
		writer<input type="text" name="writer" value="${dto.writer}">

		
		<input type="submit" value="update">
		
	</form>
</body>
</html>