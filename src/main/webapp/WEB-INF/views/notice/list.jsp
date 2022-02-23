<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>Notice List Page</h1>

	<table>
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>contents</th>
				<th>writer</th>
				<th>regDate</th>
				<th>hit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="notice">

				<tr>
					
					<td> <a href="./detail?num=${notice.num}"> ${notice.title}</a></td>
					<td>${notice.contents}</td>
					<td>${notice.writer}</td>
					<td>${notice.regDate}</td>
					<td>${notice.hit}</td>

				</tr>

			</c:forEach>

		</tbody>


	</table>

</body>
</html>