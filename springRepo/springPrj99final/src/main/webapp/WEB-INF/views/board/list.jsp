<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <%-- <link rel="stylesheet" href="${root}/resources/css/common.css" /> --%>
    <%@ include file="/resources/css/common.css" %>
  </head>
  <body>
    <div id="wrap">
      <aside>
      	<%@ include file="/WEB-INF/views/common/sidemenu-content.jsp" %>
      	<%-- <jsp:include page="페이지"></jsp:include> --%>
      </aside>

      <main>
        <a href="${root}">
          <header><img width="100%" height="100%" alt="로고이미지" src="${root}/resources/img/cookie.jpg"></header>
        </a>
        <%@ include file="/WEB-INF/views/board/list-content.jsp" %>
      </main>

      <aside>어사이드</aside>
    </div>
  </body>
</html>
