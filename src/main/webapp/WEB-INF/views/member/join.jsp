<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link>
</head>
<body>
	<h1>Member Join Page</h1>

	<div>
		<form action="./join" method="post" id="frm" enctype="multipart/form-data"> 
			<fieldset>
				<legend>ID</legend>
				<input type="text" name="id" id="id">
				<div id="idResult"></div>
			</fieldset>

			<fieldset>
				<legend>Password</legend>
				<input type="password" id="pw" name="pw" placeholder="8글자 이상 12글자 이하로 작성">
				<div id="pwResult"></div>
			</fieldset>
			
						<fieldset>
				<legend>Password 확인</legend>
				<input type="password" id="pw2" name="pw2" placeholder="8글자 이상 12글자 이하로 작성">
				<div id="pwResult2"></div>
			</fieldset>

			<fieldset>
				<legend>Name</legend>
				<input type="text" id="name" name="name">
			</fieldset>

			<fieldset>
				<legend>Phone</legend>
				<input type="text" id="phone" name="phone">
			</fieldset>


			<fieldset>
				<legend>Email</legend>
				<input type="text" id="email" name="email">
			</fieldset>
			
			<fieldset>
				<legend>Photo</legend>
				<input type="file" id="photo" name="photo">
			</fieldset>

			<fieldset>
			<!-- 최종완성시 사용? <button type="submit" id="btn">JOIN</button> -->
				<button type="submit" id="btn">JOIN</button>
			</fieldset>

		</form>
	</div>
	<!-- <script src="../resources/js/join2.js"></script> -->
</body>
</html>