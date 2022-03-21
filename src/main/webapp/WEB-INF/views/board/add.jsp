<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>${board} Add Page</h1>
	
	<form action="./add" method="post" enctype="multipart/form-data">
		
		Title<input type="text" name="title">
		Writer<input type="text" readonly="readonly" value="${member.id}" name="writer">
		Contents<textarea name="contents" rows="" cols=""></textarea>
		
		<div id="fileResult">
		



<!-- 	<div>
			<input type="file" name="files"> <button type="button">DEL</button>
		</div>

			<input type="file" name="files">
			<input type="file" name="files"> -->
		</div>
		
		<div>
			<button id="fileAdd" type="button">fileADD</button>
			<button type="button" class="del">SAMPLE DEL</button>
		</div>
		
		
		<button type="submit">Add</button>
	
	</form>
	
	<script src="../resources/js/file.js"></script>

</body>
</html>