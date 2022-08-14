<%@page import="com.kh.member.vo.MemberVo"%> <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<% 
MemberVo loginMember = (MemberVo)session.getAttribute("loginMember"); 
String alertMsg = (String)session.getAttribute("alertMsg");
session.removeAttribute("alertMsg"); 
String contextPath = request.getContextPath(); 
%>

<!DOCTYPE html>
<html>
  <head>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <style>
      #login-wrap {
        float: right;
      }
      nav {
        display: flex;
        justify-content: space-evenly;
        background-color: lightsteelblue;
        height: 50px;
        width: 60%;
        margin: 0 auto;
        text-align: center;
        font-size: 2rem;
      }
      nav a {
        color: white;
        text-decoration: none;
      }
      header::after {
        content: "";
        display: block;
        clear: both;
      }

      main {
        border: 1px dashed lightsteelblue;
        width: 60%;
        margin: 0 auto;
      }

      div {
        box-sizing: border-box;
      }

      button {
        border: 1px solid black;
      }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  </head>
  <body>
    <header>
      <h1 align="center" style="margin-top:30px">효정이의 홈페이지</h1>

      <div id="login-wrap">
        <%if(loginMember == null){ %>
        <form action="/semi/member/login" method="post">
          <table>
            <tr>
              <td>아이디</td>
              <td colspan="2"><input type="text" name="memberId" /></td>
            </tr>
            <tr>
              <td>비밀번호</td>
              <td colspan="2"><input type="password" name="memberPwd" /></td>
            </tr>
            <tr>
              <td></td>
              <td><button>로그인</button></td>
              <td><button type="button" onclick="location.href='/semi/member/join'">회원가입</button></td>
            </tr>
          </table>
        </form>
        <%} else {%> <%= loginMember.getName() %> 님 환영합니다.
        <br />
        <a href="/semi/member/myPage">마이페이지</a>
        <a href="<%=contextPath%>/member/logout">로그아웃</a>
        <%}%>
      </div>
    </header>

    <nav>
      <a href="<%=contextPath%>">HOME</a>
      <a href="<%=contextPath%>/notice/list">공지사항</a>
      <a href="<%=contextPath%>/board/list?p=1">일반게시판</a>
      <a href="">사진게시판</a>
    </nav>

    <script>
      <%if(alertMsg != null){%>
      	alert('<%= alertMsg%>');
      <%}%>
    </script>
  </body>
</html>
