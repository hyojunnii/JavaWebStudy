<%@page import="com.kh.common.PageVo"%>
<%@page import="com.kh.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	List<BoardVo> voList = (List<BoardVo>)request.getAttribute("list");
	PageVo pv = (PageVo)request.getAttribute("pv");
	
	int currentPage = pv.getCurrentPage();
	int startPage = pv.getStartPage();
	int endPage = pv.getEndPage();
	int maxPage = pv.getMaxPage();
	
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      #outer {
        width: 60%;
        height: 550px;
        margin: auto;
        padding-top: 50px;
        background-color: lightsteelblue;
        color: white;
      }

      #outer table {
        width: 95%;
        margin: auto;
      }

      #page-area {
        width: 80%;
        text-align: center;
        margin: auto;
        padding-top: 30px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>

    <div id="outer">
      <h1 align="center">게시글 조회</h1>
      <div style="text-align:right; width:95%">
      	<c:if test="${not empty loginMember}">
      		<a class="btn btn-primary" href="${cp}/board/insert">글쓰기</a>
      	</c:if>
      </div>
      <table border="1">
        <tr>
          <th>글번호</th>
          <th>카테고리</th>
          <th>제목</th>
          <th>작성자</th>
          <th>조회수</th>
          <th>작성일시</th>
        </tr>
        <c:forEach items="${list}" var="b">
	        <tr>
	          <td>${b.no}</td>
	          <td>${b.category}</td>
	          <td>${b.title}</td>
	          <td>${b.content}</td>
	          <td>${b.cnt}</td>
	          <td>${b.enrollDate}</td>
	        </tr>
        </c:forEach>
      </table>
      <div id="page-area">
      	<% if(currentPage != 1) {%>
      		<a class="btn btn-sm btn-primary" href="<%=contextPath%>/board/list?p=<%=currentPage-1%>">&lt;</a>
      	<%}%>
      	
      	<% for(int i = startPage; i <= endPage; i++) {%>
      		<% if(i == currentPage) {%>
        		<a class="btn btn-sm btn-primary"><%=i%></a>
      		<%} else {%>
        		<a class="btn btn-sm btn-primary" href="<%=contextPath%>/board/list?p=<%=i%>"><%=i%></a>
        	<%} %>
        <%} %>
        
        <% if(currentPage != maxPage) {%>
        	<a class="btn btn-sm btn-primary" href="<%=contextPath%>/board/list?p=<%=currentPage+1%>">&gt;</a>
        <%} %>
        
      </div>
    </div>
  </body>
</html>
