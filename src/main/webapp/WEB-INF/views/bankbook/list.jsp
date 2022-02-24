<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/header_css.jsp"></c:import> 
<title>Insert title here</title>
<link href="../resources/css/table.css" rel="stylesheet">
</head>
<body>
<c:import url="../template/header.jsp"> </c:import>  
	<h1 align="center">BankBook List Page</h1>

	
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