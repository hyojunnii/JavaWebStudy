<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록 조회</h1>
	
	<table border="1">
		<tr>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
			<th>삭제여부</th>
		</tr>
		<c:forEach items="${list}" var="b">
			<tr>
				<td>${b.title}</td>
				<td>${b.content}</td>
				<td>${b.enrollDate}</td>
				<td>${b.deleteYn}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>