<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	
	<form action="/my01/member/login" method="post">
		아이디 : <input type="text" name="memberId">
		<br>
		패스워드 : <input type="password" name="memberPwd">
		<input type="submit">
	</form>
</body>
</html>