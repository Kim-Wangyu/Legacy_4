<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Update Page</h1>
	
	<form action="./update" method="POST">
		<input type="hidden" name="num" value="${dto.num}" readonly="readonly">
		Title<input type="text" name="title" value="${dto.title}">
		Contents <textarea name="contents" rows="" cols="">${dto.contents}</textarea>
		
	
		
		<input type="submit" value="update">
		
	</form>
</body>
</html>