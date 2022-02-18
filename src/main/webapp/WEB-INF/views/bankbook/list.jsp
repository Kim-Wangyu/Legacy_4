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
	<h1>BankBook List Page</h1>
	<h1>${list}</h1>
	
	<!-- bookName, bookRate,bookSale -->
	
	<table>
	<thead>
		<tr>
			<th>bookName</th><th>bookRate</th><th>bookSale</th>
		</tr>
	</thead>
<tbody>
<c:forEach items="${list}" var="book">

<tr>
			<td><a href ="./detail?bookNumber=${book.bookNumber}">${book.bookName}</a></td>
			<td>${book.bookRate}</td>
			<td>${book.bookSale}</td>
		</tr>
		</c:forEach>
</tbody>
</table>

	<a href="./add">ADD</a>
</body>
</html>