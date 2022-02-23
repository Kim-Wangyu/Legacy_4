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
		<input type="hidden" name="bookNumber" value="${dto.bookNumber}" readonly="readonly">
		BookName<input type="text" name="bookName" value="${dto.bookName}">
		BookRate<input type="text" name="bookRate" value="${dto.bookRate}">
		BookContents <textarea name="bookContents" rows="" cols="">${dto.bookContents}</textarea>
		BookSale 
		<div>
			팜<input type="radio" name="bookSale" value="1"> 
			안팜<input type="radio" name="bookSale" value="0">
		</div>
		
		<input type="submit" value="update">
		
	</form>
</body>
</html>