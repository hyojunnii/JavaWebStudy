<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>인덱스 페이지 (ajax 테스트)</h1>
	
	<input type="text" id="t" >
	
	<button onclick="test();">클릭</button>
	
	<div id="result">
		결과 영역
	</div>
	
	<script type="text/javascript">
		function test() {
			/* 
			load : 비동기 통신
			-> 새로고침 없이 새로운 데이터 보기
			
			단점 : 데이터 보낼 수 없음
				요청을 get방식으로 보내고 있음
				응답받은 데이터를 다루기 쉽지 않음
				요청 실패에 대한 처리를 할 수 없음
			*/
			//$("#result").load("/web16/kh")
			
			const temp = $('#t').val();
			
			//ajax
			/* url, method, data, success : f01, error : f02 */
			$.ajax({
				url : "/web16/kh", 
				method : "GET", 
				data : {
							userId : temp, 
						},
				success : function (x){
					console.log("통신성공");
					console.log(x);
					const result = JSON.parse(x);
					console.log(result);
				},
				error : function (e){
					console.log("통신실패");
					console.log(e)
				}
			});
		}
	
	</script>
</body>
</html>