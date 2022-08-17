<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String v = (String)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>view01</h1>
	
	<!-- 
		el표현식 $
		- 같은 키값이 있는 경우 좁은 범위부터 탐색 
			: page < request < session < app
	-->
	<h3>${requestScope.data}</h3> 
	<h3>${sessionScope.data}</h3>
	<h3>${applicationScope.data}</h3>
	
	<hr>
	
	<!-- 배열 데이터 꺼내기 -->
	<h3>${fruits[0]}</h3>
	<h3>${fruits[1]}</h3>
	<h3>${fruits[2]}</h3>

	<hr>
	
	<!-- 맵의 데이터 꺼내기 -->
	<h3>${fruitsMap.first}</h3>
	<h3>${fruitsMap.second}</h3>
	<h3>${fruitsMap.third}</h3>
	
	<hr>

	<!-- 객체의 데이터 꺼내기 -->
	<h3>${member.memberId}</h3>
	<h3>${member.memberPwd}</h3>
	<h3>${member.memberNick}</h3>
	
	<hr>
	
	<!-- 파라미터의 값 꺼내기 -->
	<h3>${param.num}</h3>
	
	<hr>
	
	<h3>나이 : ${age-2}</h3>
	
	<!--
		< lt > gt
		<= le >= ge
		== : eq
		!= : ne 
		|| : or 
		&& : and
		! : not
		삼항연산자
		empty : null 또는 빈 문자열
	-->
	
	<h3>${param.num eq 10}</h3> 
	<h3>${param.num ne 10}</h3>
	
	<h3>비어있는지 : ${empty param.num}</h3>
	
	<h3>${empty param.num ? "숫자를 입력해주세요" : "값 : " + param.num}</h3>
	
</body>
</html>