<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	* 프레임 워크
	- 개발자가 편리한 환경에서 개발할 수 있도록 제공하는 틀
	
	* 필요성
	- 규모가 큰 프로젝트의 경우, 많은 개발자 필요함
		- 통일성, 빠르게, 안정성
		- 생산성 향상
	
	* 특징
	- 개발자들이 따라야 하는 가이드라인 제공
	- 개발 범위가 정해져 있음
	- 다양한 도구들을 지원

	* 장점
	- 개발 시간 단축
	- 유지보수 용이
	
	* 단점
	- 프레임워크 의존도가 높아지면, 개발자 능력이 떨어짐
	- 러닝커브가 높음
	
	* 종류
	- 영속성 : 데이터관련하여 CRUD 기능들을 편리하게 작업할 수 있도록 제공하는 프레임워크
		ex) MyBatis, Hibernate, JPA
	- 자바 : 웹 어플리케이션에 초점을 맞춰 필요한 요소들을 모듈화해서 제공하는 프레임워크
		ex) spring, struts, spring-boot
	- 화면구현 : FrontEnd를 쉽게 구현할 수 있도록 제공하는 프레임워크
		ex) Bootstrap
	- 기능 및 지원 : 특정 기능이나 업무 수행에 도움을 줄 수 있게 제공하는 프레임워크
		ex) Log4j
 -->
 
 	<h1>인덱스</h1>

	<jsp:forward page="/WEB-INF/views/main.jsp"></jsp:forward>

	<!-- 
	마이바티스
	
	0.준비
	- mybatis.jar (mvn repo || 공식문서의 깃허브)
	- ojdbc.jar
	
	1.설정파일 작성 (SqlSessionFactoryBuilder를 위한)
	- source folder 만들기
	- mybatis-config.xml 문서 작성
		- DTD (doctype configuration)
		- 마이바티스 설정 정보 작성 (공식문서 참조)
		
	2. SqlSession 얻기(SqlSessionFactoryBuilder -> SqlSessionFactory -> sqlSession)
	- xml 문서를 이용하여 (빌더 -> 팩토리 -> 세션) 얻기 //SqlTemplate 파일에 static으로 작성
	
	3. SQL 실행
	- DML, DQL
	- ss.xxx("네임스페이스.식별자", "물음표를 채울 데이터");
	
	4. mapper 작성
	- source folder > mapper > member-mapper.xml 파일 생성
	- dtd 작성 (공식문서 참조)
	- mapper 태그 작성 및 내용 채우기
		- SQL구문 태그 <insert | update | delete | select>
		- resultMap 태그 
	
	5. mapper 파일 등록
	- mybatis-config.xml에 mapper 등록
	 -->

</body>
</html>