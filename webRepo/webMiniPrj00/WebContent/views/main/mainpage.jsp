<%@page import="java.util.List"%>
<%@page import="com.kh.board.vo.BoardVo"%>
<%@page import="com.kh.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<% 
List<BoardVo> boardList = (List<BoardVo>)session.getAttribute("boardList");
String msg = (String)session.getAttribute("alertMsg");
session.removeAttribute("alertMsg");
MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
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
        margin: 5% auto;
      }
      
      #main-content {
      	margin: 8% 5%;
      	display: flex;
      }
      
      #member {
      	width: 30%;
      }
      
      #board {
      	width: 70%;
      }

      #login {
        width: 80%;
      }

      #login-menu {
        display: flex;
        justify-content: space-between;
      }
    </style>
  </head>
  <body>
    <h1 align="center" style="background-color: $primary">MiniMi HOME</h1>
    <h5 align="center">미니미홈에 오신걸 환영합니다.</h5>

	<div id="main-content">
		<div id="member">
			<% if(loginMember == null) {%>
			    <div id="login">
			      <form action="/webMiniPrj/member/login" method="post">
			        <div class="mb-3">
			          <label for="exampleInputEmail1" class="form-label">아이디</label>
			          <input type="text" class="form-control" id="exampleInputEmail1" name="memberId" />
			        </div>
			        <div class="mb-3">
			          <label for="exampleInputPassword1" class="form-label">패스워드</label>
			          <input type="password" class="form-control" id="exampleInputPassword1" name="memberPwd" />
			        </div>
			        <div id="login-menu">
			          <button type="submit" class="btn btn-primary">로그인</button>
			          <a class="btn btn-secondary" href="/webMiniPrj/member/join">회원가입</a>
			        </div>
			      </form>
			    </div>
		    <%} else {%>
				<div class="card border-primary mb-3" style="width: 80%;" id="logined">
				  <div class="card-header"><%=loginMember.getId()%>님 환영합니다!</div>
				  <div class="card-body text-secondary">
				    <h5 class="card-title text-primary"><%=loginMember.getNick()%></h5>
				    <p class="card-text"><%=loginMember.getComment()%></p>
				    <a href="/webMiniPrj/member/mypage" class="card-link" style="font-size: 15px; text-decoration:none">마이페이지</a>
				    <a href="/webMiniPrj/member/logout" class="card-link" style="font-size: 15px; text-decoration:none">로그아웃</a>
				  </div>
				</div>
		    <%}%>
		</div>
	    
	    <div id="board">
	    	<nav class="navbar navbar-expand-sm">
			  <div class="container-fluid justify-content-between">
			    <a class="navbar-brand" href="/webMiniPrj/main">HOME 전체글보기</a>
			    <%if(loginMember != null) {%>
			    <div>
			    	<a class="btn btn-sm btn-outline-primary" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop">게시글 작성하기</a>
			    	<a class="btn btn-sm btn-outline-success" type="button" href="/webMiniPrj/board/mylist">나의 글 보기</a>
			    </div>
			    <%} %>
			  </div>
			</nav>
			<!-- Modal -->
			<div class="modal" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			  <div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="staticBackdropLabel">게시글 작성하기</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <form action="/webMiniPrj/board/insert" method="post">
				      <div class="modal-body">
				      	<div class="mb-3 row">
				          <label class="col-sm-3 col-form-label">카테고리</label>
				          <div class="col-sm-9">
				            <select class="form-select" name="category">
							  <option value="일반">일반</option>
							  <option value="가입인사">가입인사</option>
							  <option value="게임">게임</option>
							  <option value="음악">음악</option>
							  <option value="운동">운동</option>
							  <option value="요리">요리</option>
							  <option value="기타">기타</option>
							</select>
				          </div>
				        </div>
			            <div class="mb-3 row">
				          <label class="col-sm-3 col-form-label">제목</label>
				          <div class="col-sm-9">
				            <input type="text" class="form-control" name="title" required/>
				          </div>
				        </div>
				        <div class="mb-3 row">
				          <label class="col-sm-3 col-form-label">내용</label>
				          <div class="col-sm-9">
				          	<textarea class="form-control" name="content" style="height:400px" maxlength="1000" placeholder="1000자 이내로 적어주세요." required="required"></textarea>
				          </div>
				        </div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
				        <button type="submit" class="btn btn-primary">작성하기</button>
				      </div>
			      </form>
			    </div>
			  </div>
			</div>
			
	      <table class="table table-striped">
	        <thead>
	          <tr class="table-primary">
	            <th scope="col">#</th>
	            <th scope="col">카테고리</th>
	            <th scope="col">제목</th>
	            <th scope="col">작성자</th>
	            <th scope="col">조회수</th>
	          </tr>
	        </thead>
	        <tbody>
       			<% for(BoardVo b : boardList) {%>
		        <tr>
		          <th scope="row"><%=b.getNo() %></td>
		          <td><%=b.getCategory() %></td>
		          <td><%=b.getTitle() %></td>
		          <td><%=b.getWriter() %></td>
		          <td><%=b.getCnt() %></td>
		        </tr>
	     	 	<%}%>
		        <tr>
		          <th scope="row">0</td>
		          <td>공지</td>
		          <td>미니미홈 사용법</td>
		          <td>관리자</td>
		          <td>99</td>
		        </tr>
	        	<tr>
		          <th scope="row">0</td>
		          <td>공지</td>
		          <td>미니미홈 소개</td>
		          <td>관리자</td>
		          <td>125</td>
		        </tr>
	        </tbody>
	      </table>
	    </div>
		
	</div>
    <script>
      <% if(msg != null) {%>
      	alert('<%=msg%>');
      <%}%>
    </script>
  </body>
</html>