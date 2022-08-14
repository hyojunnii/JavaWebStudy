<%@page import="com.kh.notice.vo.NoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	NoticeVo vo = (NoticeVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      #outer {
        background-color: lightsteelblue;
        color: white;
        width: 60%;
        height: 50vh;
        margin: auto;
      }

      #outer h1 {
        padding-top: 30px;
      }

      #section {
        border: 1px solid white;
        width: 90%;
        height: 60%;
        margin: auto;
      }

      #section * {
        width: 100%;
      }

      #div-btn-area {
        width: 35%;
        margin: auto;
        margin-top: 30px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
	
    <div id="outer">
      <h1 align="center">공지사항 수정하기</h1>
      
      <form action="<%=contextPath%>/notice/edit" method="post">
      	<input type="hidden" name="num" value="<%=vo.getNo()%>"/>
        <input type="hidden" name="writerNo" value="<%= loginMember.getNo()%>" />
        <div id="section">
          제목 <input type="text" name="title" required value="<%=vo.getTitle()%>"/>
          <br />
          내용
          <br />
          <textarea rows="8" style="resize: none" name="content" required><%=vo.getContent()%></textarea>
        </div>

        <div id="div-btn-area">
          <input type="submit" value="수정하기" />
          <input type="reset" value="초기화" />
          <input type="button" value="뒤로가기" onclick="history.go(-1)" />
        </div>
      </form>
    </div>
  </body>
</html>