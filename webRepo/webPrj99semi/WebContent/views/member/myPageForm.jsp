<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      main table {
        margin: 0 auto;
      }

      main {
        background-color: lightsteelblue;
        color: white;
      }
      
      #pwdFormOuter {
      	display : flex;
      	justify-content : center;
      }
      
      #pwdFormOuter > td:last-child {
      	display : flex;
      	justify-content: right;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>

    <main>
      <h1 align="center">마이페이지</h1>
      <form action="/semi/member/myPage" method="post">
      	<input type="hidden" value="<%=loginMember.getNo()%>" name="memberNo">
        <table>
          <tr>
            <td>* 아이디</td>
            <td><input class="form-control form-control-sm" type="text" name="memberId" value="<%=loginMember.getId() %>" maxlength="10" required readonly/></td>
          </tr>
          <tr>
            <td>* 이름</td>
            <td><input class="form-control form-control-sm" type="text" name="memberName" value="<%=loginMember.getName() %>" maxlength="3" required /></td>
          </tr>
          <tr>
            <td>전화번호</td>
            <td><input class="form-control form-control-sm" type="tel" name="memberPhone" value="<%=loginMember.getPhone() %>" placeholder="- 없이 입력" /></td>
          </tr>
          <tr>
            <td>이메일</td>
            <td><input class="form-control form-control-sm" type="email" name="memberEmail" value="<%=loginMember.getEmail() %>"/></td>
          </tr>
          <tr>
            <td>주소</td>
            <td><input class="form-control form-control-sm" type="text" name="memberAddr" value="<%=loginMember.getAddr() %>"/></td>
          </tr>
          <tr>
            <td>관심분야</td>
            <td>
              <input class="form-check-input" type="checkbox" name="interest" value="game" id="game" /> <label for="game">게임</label>
              <input class="form-check-input" type="checkbox" name="interest" value="workout" id="workout" /> <label for="workout">운동</label>
              <input class="form-check-input" type="checkbox" name="interest" value="cook" id="cook" /> <label for="cook">요리</label>
              <br />
              <input class="form-check-input" type="checkbox" name="interest" value="music" id="music" /> <label for="music">음악</label>
              <input class="form-check-input" type="checkbox" name="interest" value="book" id="book" /> <label for="book">독서</label>
              <input class="form-check-input" type="checkbox" name="interest" value="draw" id="draw" /> <label for="draw">그림</label>
            </td>
          </tr>
          <tr>
            <td><input id="" type="submit" value="회원정보변경" class="btn btn-primary"/></td>
            <td>
            	<input id="" type="button" value="비밀번호변경" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#pwdChange"/>
            	<input id="" type="button" value="회원탈퇴" class="btn btn-secondary" onclick="location.href='/semi/member/quit'"/>
            </td>
          </tr>
        </table>
      </form>
    </main>
    
	<!-- The Modal -->
	<div class="modal" id="pwdChange">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">비밀번호 변경</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	      	<div id="pwdFormOuter">
		      	<form action="<%=contextPath%>/member/pwd" method="post">
		      		<input type="hidden" name="memberId" value="<%=loginMember.getId()%>">
			        <table>
			        	<tr>
				        	<td>기존 비밀번호 </td>
			        		<td><input type="password" name="memberPwd" required></td>
			        	</tr>
			        	<tr>
					        <td>신규 비밀번호 </td>
			        		<td><input type="password" name="memberPwdNew" required></td>
			        	</tr>
			        	<tr>
					        <td>신규 비밀번호 확인 </td>
			        		<td><input type="password" name="memberPwdNew2" required></td>
			        	</tr>
			        	<tr>
			        		<td colspan="2"><input type="submit" value="변경하기" onclick="return checkPwd();"></td>
			        	</tr>
			        </table>
		      	</form>
	      	</div>
	      </div>
	
<!-- 	      Modal footer
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div> -->
	
	    </div>
	  </div>
	</div>
	
	<script>
		function checkPwd(){
			const isSame = $('input[name=memberPwdNew]').val() == $('input[name=memberPwdNew2]').val();
			if(isSame) {
				return true;
			} else {
				alert("신규 비밀번호가 일치하지 않습니다.")
				return false;
			}
		}
	</script>
    
    <script>
    	$(function(){
    		//로그인 유저의 취미 가져오기
    		const interest = '<%=loginMember.getInterest()%>';
    		
    		//체크박스 가져오기
    		$('input[name=interest]').each(function(){
    			var result = interest.indexOf(this.value);
    			if(result != -1) {
    				 this.checked = true;
    			}
    		})
    		
    	})
    </script>
    
  </body>
</html>
