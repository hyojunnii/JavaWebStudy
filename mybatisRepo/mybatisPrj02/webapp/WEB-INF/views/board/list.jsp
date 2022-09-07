<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      div {
        box-sizing: border-box;
      }

      #main {
        width: 60vw;
        height: 60vh;
        margin: auto;
      }

      #search-area {
        display: flex;
        justify-content: center;
      }

      #table-area {
        width: 100%;
        height: 80%;
        border: 5px solid black;
        border-collapse: collapse;
        display: flex;
        justify-content: center;
        align-items: flex-start;
      }

      table td {
        border: 1px dashed black;
      }

      #page-area {
        width: 100%;
        height: 20%;
        display: flex;
        justify-content: center;
      }

      #page-area > div {
        width: 50%;
        display: flex;
        justify-content: space-evenly;
      }
    </style>
  </head>
  <body>
    <h1 align="center">게시글 목록</h1>

    <div id="search-area">
      <form action="/my02/board/list" method="get">
        <input type="hidden" name="p" value="1" />
        <select name="condition">
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
        <input type="text" name="keyword" value="${keyword}"/>
        <input type="submit" value="검색" />
      </form>
    </div>
    
    <c:if test="${not empty condition}">
    <script>
    	window.onload = function() {
    		document.querySelector('option[value=${condition}]').selected = true;
    	}
    </script>
    </c:if>

    <div id="main">
      <div id="table-area">
        <table>
          <tr>
            <th>제목</th>
            <th>내용</th>
            <th>등록일</th>
            <th>삭제여부</th>
          </tr>
          <c:forEach items="${list}" var="b">
            <tr>
              <td>${b.title}</td>
              <td>${b.content}</td>
              <td>${b.enrollDate}</td>
              <td>${b.deleteYn}</td>
            </tr>
          </c:forEach>
        </table>
      </div>
      <div id="page-area">
        <div>
          <c:forEach begin="${pvo.startPage}" end="${pvo.endPage}" var="i">
            <a href="/my02/board/list?p=${i}&condition=${condition}&keyword=${keyword}">${i}</a>
          </c:forEach>
        </div>
      </div>
    </div>
  </body>
</html>
