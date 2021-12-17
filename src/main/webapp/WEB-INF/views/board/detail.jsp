<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/text.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h2>detail.jsp</h2>
	<c:choose>
	<c:when test="${sessionScope.loginId eq board.b_writer}">
	<td><a href="delete?b_number=${board.b_number}">삭제</a></td>
	<td><a href="update?b_number=${board.b_number}">수정</a></td>
		<a href="/board/paging?page=${page}">글목록</a><br>
	</c:when>
	
	<c:when test="${sessionScope.loginId != null }"> 
		<a href="/board/paging?page=${page}">글목록</a><br>
	</c:when>
</c:choose>

	글번호: ${board.b_number}<br>
	작성자: ${board.b_writer}<br>
	제목: ${board.b_title}<br>
	내용: ${board.b_contentsl}<br>
	작성일자: ${board.b_date}<br>
	조회수: ${board.b_hits}<br>
	

			           
	<!--  댓글작성 -->
	<div id="comment-write">
	<input type="hidden" id="b_number" value="${detail.b_number }">
		<input type="text" id="c_writer" value="${sessionScope.loginId}" readonly>
		<textarea id="c_contentsl" name="c_contentsl" placeholder="내용"></textarea>
		<button id="comment-write-btn">댓글등록</button>
	</div>
	
	<!-- 댓글목록출력 -->
	<div id="comment-list">
		<table>
			<thead>
				<tr>
					<th>댓글번호</th>
					<th>작성자</th>
					<th>내용</th>
					<th>작성시간</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${commentList}" var="comment">
					<tr>
						<td>${comment.c_number}</td>
						<td>${comment.c_writer}</td>
						<td>${comment.c_contentsl}</td>
						<td>${comment.c_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>

	<script>
	/* const commentBtn = document.getElementById("comment-write-btn");
	commentBtn.addEventListener("click", function(){
			console.log("댓글등록버튼 클릭");
	}); */
	$("#comment-write-btn").click(function(){
		console.log("댓글등록버튼 클릭");
		// ajax 문법을 이용하여 댓글 작성자, 작성내용을 cooment/save 주소로 post 방식으로 전송하는 코드 작성
		// commentController도 하나 선언해서 여기서 보낸 데이터를 받는지 sysout으로 출력
		// 팁) data: {"c_writer": 작성자입력값, "c_contents": 내용입력값}
		/* 실행해봐요 */
		/* const commentWriter = document.getElementById("c_write").value;
		const commentContentsl = document.getElementById("c_contentsl").value; */
		const commentWriter = $("#c_writer").val();
		const commentContentsl = $("#c_contentsl").val();
		console.log(commentContentsl);
		const boardNumber = '${board.b_number}';
		console.log(commentContentsl, boardNumber);
		$.ajax({
			type: 'post',
			url: '/comment/save',
			data:{
				'c_writer': commentWriter,
				'c_contentsl': commentContentsl,
				'b_number': boardNumber},
				dataType: 'json',
				success: function(result){
					
					 console.log("과연")
			            console.log(result)
			            console.log(result);
			            let output = "<table class='table'>";
			            output += "<tr><th>댓글번호</th>";
			            output += "<th>작성자</th>";
			            output += "<th>내용</th>";
			            output += "<th>작성시간</th></tr>";
			            for(let i in result){
			               output += "<tr>";
			               output += "<td>"+result[i].c_number+"</td>";
			               output += "<td>"+result[i].c_writer+"</td>";
			               output += "<td>"+result[i].c_contentsl+"</td>";
			               output += "<td>"+result[i].c_date+"</td>";
			               output += "</tr>";
			            }
			            output += "</table>";
			            // id가 comment-list인 div에 출력
			            document.getElementById('comment-list').innerHTML = output;
			            // 댓글 입력창을 비움. 			        
			            document.getElementById('c_contentsl').value='';
			         },
			         error:function(){
			            console.log("다시");
			         }
			      });
			   }); 
					
			   
			   
</script>

</html>






