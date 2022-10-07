<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
  #center {
    width: 60vw;
    height: 60vh;
    border: 5px solid black;
    display: grid;
    grid-template-columns: 1fr 5fr 3fr 1fr;
    grid-template-rows: repeat(11, 20px);
    row-gap: 10px;
    align-content: center;
  }

  .table-header {
    text-align: center;
  }

  #center > div {
    border-bottom: 1px dashed black;
    text-align: center;
  }

  #page-area {
    width: 30%;
    margin: 0 auto;
    display: flex;
    justify-content: space-evenly;
  }
</style>

<div id="center">
  <div class="table-header">번호</div>
  <div class="table-header">제목</div>
  <div class="table-header">작성자</div>
  <div class="table-header">조회수</div>

  <c:forEach items="${voList}" var="x">
    <div>${x.no}</div>
    <div><a href="${root}/board/detail/${x.no}">${x.title}</a></div>
    <div>${x.writer}</div>
    <div>${x.hit}</div>
  </c:forEach>
</div>

<c:if test="${not empty loginMember}">
  <div style="text-align: right">
    <a href="${root}/board/write">글 작성</a>
  </div>
</c:if>

<div id="page-area">
  <a class="btn btn-primary btn-sm" href="">&lt</a>
  <a class="btn btn-primary btn-sm" href="">1</a>
  <a class="btn btn-primary btn-sm" href="">2</a>
  <a class="btn btn-primary btn-sm" href="">3</a>
  <a class="btn btn-primary btn-sm" href="">4</a>
  <a class="btn btn-primary btn-sm" href="">5</a>
  <a class="btn btn-primary btn-sm" href="">&gt</a>
</div>
