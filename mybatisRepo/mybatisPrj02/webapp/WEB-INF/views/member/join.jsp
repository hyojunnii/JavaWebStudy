<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<form action="/my02/member/join" method="post">
		아이디 : <input type="text" name="id">
		<br>
		패스워드 : <input type="password" name="pwd">
		<br>
		닉네임 : <input type="text" name="nick">
		<input type="submit">
	</form>
</body>
</html>