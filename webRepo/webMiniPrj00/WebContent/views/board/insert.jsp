<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
    <h1 align="center">게시글 작성하기</h1>

    <div id="form-outer">
      <form action="/webMiniPrj/member/join" method="post">       
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">카테고리</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" name="addr" required/>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">제목</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" name="phone" required/>
          </div>
        </div>
        <div class="mb-3 row">
          <label class="col-sm-3 col-form-label">내용</label>
          <div class="col-sm-9">
          	<textarea class="form-control" name="comment" maxlength="100" placeholder="100자 이내로 적어주세요."></textarea>
          </div>
        </div>
        <div id="form-btn">
          <button type="submit" class="btn btn-primary btn-lg">회원가입</button>
        </div>
      </form>
    </div>
  </body>
</html>
