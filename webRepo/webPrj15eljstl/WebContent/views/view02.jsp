<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>view02</h1>
	
	<c:if test="${empty userId}">
		<h3>로그인 해주세요</h3>
	</c:if>
	<c:if test="${not empty userId}">
		<h3>${userId}님 환영합니다.</h3>
	</c:if>
	
	<hr>
	
	<c:forEach items="${foods}" var="food">
		<h3>${food}</h3> 
	</c:forEach>
	
	<c:forEach begin="0" end="2" step="1" varStatus="st">
		<h3>${st.current}</h3> 	<!-- 현재객체 -->
		<h3>${st.index}</h3>	<!-- 인덱스 -->
		<h3>${st.count}</h3>	<!-- 반복횟수 -->
		<h3>${st.first}</h3>	<!-- 현재객체가 첫번째인지 -->
		<h3>${st.last}</h3>		<!-- 현재객체가 마지막인지 -->
		<h3>${st.begin}</h3>	<!-- 시작값 -->
		<h3>${st.end}</h3>		<!-- 종료값 -->
		<h3>${st.step}</h3>		<!-- 증감값 -->
		<hr>
	</c:forEach>
	
	<c:forEach items="${foods}" var="f" varStatus="vs">
		<c:if test="${not vs.last }">
			<h3>${f}</h3> 
		</c:if>
	</c:forEach>
	
	<hr>
	
	<c:out value="${param.data}" default="기본값"></c:out> <!-- 순수 문자열로 처리 -->
	
	<%-- <c:set></c:set> --%>
	
	<c:choose>
		<c:when test=""></c:when>
		<c:when test=""></c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	<hr>
	
	${fn:length(foods)}
	
	<h3>${fn:split("abc,123,hello,bye", ",")[0]}</h3>
	
	${fn:toLowerCase("ABC")}
	
	<hr>
	
	<fm:parseDate value="2022/08/17" var="today" pattern="yyyy/MM/dd"></fm:parseDate>
		
	<fm:formatDate value="${today}" pattern="yyyy-MM-dd"/>
	
</body> 
</html>