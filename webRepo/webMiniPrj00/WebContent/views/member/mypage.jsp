<%@page import="com.kh.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	String msg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <style>
      body {
        width: 1000px;
        margin: 0 auto;
      }

      h1 {
        margin: 7%;
      }

      #form-outer {
        margin: 0 auto;
        width: 60%;
      }

      #form-btn {
        padding-top: 5%;
        display: flex;
        justify-content: center;
      }
    </style>
  </head>
  <body>
    <h1 align="center">MiniMi 마이페이지</h1>

    <div id="form-outer">
      <form action="/webMiniPrj/member/edit" method="post">
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">아이디</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" name="id" minlength="4" value="<%=loginMember.getId()%>" disabled />
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">이름</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" name="name" minlength="2" value="<%=loginMember.getName()%>" disabled/>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">닉네임</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" name="nick" required value="<%=loginMember.getNick()%>" disabled/>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">이메일</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" name="email" required value="<%=loginMember.getEmail()%>"/>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">전화번호</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" name="phone" required value="<%=loginMember.getPhone()%>"/>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">주소</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" name="addr" required value="<%=loginMember.getAddr()%>"/>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">소개</label>
          <div class="col-sm-9">
          	<textarea class="form-control" name="comment" maxlength="100" placeholder="100자 이내로 적어주세요."><%=loginMember.getComment()%></textarea>
          </div>
        </div>
        <div id="form-btn" class="gap-4">
          <a type="button" class="btn btn-success btn-lg" href="/webMiniPrj/main">홈으로</a>
          <button type="submit" class="btn btn-primary btn-lg">회원정보수정</button>
          <a type="button" class="btn btn-secondary btn-lg" href="/webMiniPrj/member/quit">회원탈퇴</a>
        </div>
      </form>
    </div>
    <script>
      <% if(msg != null) {%>
      	alert('<%=msg%>');
      <%}%>
    </script>
  </body>
</html>