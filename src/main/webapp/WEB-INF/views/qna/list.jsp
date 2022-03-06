<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

				<h1 class="title">QNA List Page1</h1>


				<!--검색창-->
				<div>
					<form action="./list" method="get">
						<fieldset>
							<select name="kind">
								<option value="col1">타이틀</option>
								<option value="col2">본문</option>
								<option value="col3">작성자</option>
							</select>

							<input type="text" name="search" value="${pager.search}">
							<button type="submit">검색</button>
						</fieldset>
					</form>

				</div>

			<!-- title, contents, writer -->

			<table class="table-basic">
				<thead>
					<tr class="tr1">
						<th>num</th>
						<th>title</th>
						<th>contents</th>
						<th>writer</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="qna">

						<tr>
							<td>${qna.num}</td>
							<td><a href="./detail?num=${qna.num}">${qna.title}</a></td>
							<td>${qna.contents}</td>
							<td>${qna.writer}</td>
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