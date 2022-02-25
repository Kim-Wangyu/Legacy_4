<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:import url="../template/header_css.jsp"></c:import>

			<link href="../resources/css/tableee.css" rel="styleSheet" />
			<link href="../resources/css/list.css" rel="styleSheet" />
		</head>

		<body>
			<c:import url="../template/header.jsp"></c:import>

			<div class="table-container">

				<h1 class="title">BankBook List Page1</h1>


				<!--검색창-->
				<div>
					<form action="./list" method="get">
						<fieldset>
							<select name="kind">
								<option value="col1">제목</option>
								<option value="col2">본문</option>
								<option value="col3">작성자</option>
							</select>

							<input type="text" name="search" value="${pager.search}">
							<button type="submit">검색</button>
						</fieldset>
					</form>

				</div>

			<!-- bookName, bookRate,bookSale -->

			<table class="table-basic">
				<thead>
					<tr class="tr1">
						<th>상품번호</th>
						<th>bookName</th>
						<th>bookRate</th>
						<th>bookSale</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="book">

						<tr>
							<td>${book.bookNumber}</td>
							<td><a href="./detail?bookNumber=${book.bookNumber}">${book.bookName}</a></td>
							<td>${book.bookRate}</td>
							<td>${book.bookSale}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


			<div>
				<c:if test="${pager.pre}">
					<a href="./list?page=${pager.startNum-1}">PREVIEW</a>
				</c:if>


				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i} </a>
				</c:forEach>

				<c:if test="${pager.next}">
					<a href="./list?page=${pager.lastNum+1}">NEXT</a>
				</c:if>
			</div>

			<a href="./add">ADD</a>
			</div>
		</body>

		</html>