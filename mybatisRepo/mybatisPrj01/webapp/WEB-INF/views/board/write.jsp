<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	
	<form action="/my01/board/insert" method="post">
		제목 : <input type="text" name="title">
		<br>
		내용 : <textarea name="content"></textarea>
		<input type="submit">
	</form>
</body>
</html>