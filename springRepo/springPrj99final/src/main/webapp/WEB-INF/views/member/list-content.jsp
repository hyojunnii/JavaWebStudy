<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
  #main {
    width: 100%;
    height: 60vh;
    border: 5px solid black;
    display: grid;
    grid-template-columns: repeat(4, 100px);
    grid-template-rows: repeat(2, 130px);
    justify-content: center;
    align-content: center;
    gap: 50px;
  }

  #main > div {
    border: 1px solid black;
  }
  
  .gallery-img-box {
  	width: 100%;
  	height: 100px;
  }
</style>

<div id="main">
  <c:forEach items="${voList}" var="l">
    <div>
        <div class="gallery-img-box">
            <img width="100%" height="100%" src="${root}/resources/upload/profile/${l.fileName}" alt="${l.nick}">
        </div>
        <span>${l.nick}</span>
    </div>
  </c:forEach>
</div>
