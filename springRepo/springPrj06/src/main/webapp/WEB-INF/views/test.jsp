<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리다이렉트</h1>
	
	<h3>일회용 데이터 (리퀘):: ${requestScope.msg}</h3>
	<h3>일회용 데이터 (세션):: ${sessionScope.msg}</h3>
</body>
</html>