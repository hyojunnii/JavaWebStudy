<%@page import="com.kh.user.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	UserDto loginUser = (UserDto)session.getAttribute("loginUser");
    
    	String alertMsg = (String)session.getAttribute("abc");
    	
    	if("로그아웃 성공!".equals(alertMsg)){
    		session.invalidate(); //세션만료
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>* 환영합니다 *</h1>
	
	<%if(loginUser != null){%>
		<h2><%= loginUser.getNick() %>님 환영합니다</h2>
		<a href="/webPrj14/user/logout">로그아웃</a>
	<%} else {%>
		<a href="/webPrj14/views/user/login.jsp">로그인</a>
		<a href="/webPrj14/views/user/join.jsp">회원가입</a>
	<%}%>
	
	<script>
		<%if(alertMsg != null){%>
			alert('<%= alertMsg%>');
		<%}%>
	</script>

<!--
1. 화면 -> 서버 데이터 전송
form / action / method / input name

2. 서버에서 데이터 받가
servlet / request / getParamater

3. 서버에서 데이터 처리

4. 서버 화면
servlet / response / write/print

서버의 저장영역 4가지
servlet < response < session < application
-->
 
<!-- 
포워드
>> 서버 안에서 넘기는거
>> 서블릿 , JSP 얘네가 서로 넘기는거

리다이렉트
>> 클라이언트한테, 다시 요청하게 하는거
>> 서버가 응답을 하긴함.  "누구한테 다시 요청하세요 ~" 라고 응답함
>> 그러면, 클라이언트는 다시 요청 보냄

어트리뷰트
>> 저장공간에 데이터 담을 때 사용함
>> 저장공간은? 4가지 있음 (페이지, 리쿼스트, 세션, 어플리케이션)

>> 서버 안에서 데이터 저장할 때 사용함
>> 클라이언트가 보낸 데이터는 attr 아니고 param 임

프로퍼티스 (driver, url, id, pwd)
>> txt랑 다를바가 없음
>> txt 파일로 해도 되는데, 편하게 하려고 사용함
>> 뭐가 편함? >> key ,value 형태로 데이터 사용 가능
>> java 의 프로퍼티 객체에 load 해서 사용 가능함
-->

<!--
.properties 파일 쓰는 이유

>> 자바 코드에 driver , url , id, pwd 이런거 쓰면 안됨
정보노출 , 보안 , 운영 불편함
자바코드에 직접 String 입력하면?
문자열 바뀔때 마다 , 빌드 -> 컴파일 -> 배포 다시해야됨

=> 파일로 관리해야함
그러면? 파일만 바꾸면, url, id, pwd 다 바꿀 수 있음
txt 파일로 관리할건데 좀 더 편하게 관리하고싶음
그래서 쓰는게 프로퍼티즈 (키 밸류 로 가져올 수 있으니까)
-->
</body>
</html>

