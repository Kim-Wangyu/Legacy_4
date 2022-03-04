<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook ADD Page</h1>
	
	<form action="./add" method="POST">
		BookName<input type="text" name="bookName" id="bName">
		BookRate<input type="text" name="bookRate" id="bRate">
		BookContents <textarea name="bookContents" rows="" cols="" id="bContents"></textarea>
		BookSale 
		<div>
			팜<input type="radio" name="bookSale" value="1"> 
			안팜<input type="radio" name="bookSale" value="0">
		</div>
		
		<input type="submit" value="ADD">
		
	</form>
	<script type="text/javascript" src="../resources/js/bankbook.js"></script>
</body>
</html>