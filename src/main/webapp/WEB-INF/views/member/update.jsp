<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Update Page</h1>
	
	<form action="./update" method="POST">
		ID<input type="hidden" name="id" value="${dto.id}" readonly="readonly">
		PW<input type="text" name="pw" value="${dto.pw}">
		Name<input type="text" name="name" value="${dto.name}">
		Phone<input type="text" name="phone" value="${dto.phone}">
		Email<input type="text" name="email" value="${dto.email}">
		
		
		
	
		
		<input type="submit" value="update">
		
	</form>
</body>
</html>