<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input{
	display: block;
	}
</style>

</head>
<body>
<h2>update.jsp</h2>
	<form action="/board/update" method="post" name="update_form">
		<input type ="hidden" name="page" value="${page}">
		글번호: <input type="text" name="b_number" value="${board.b_number}" readonly>
		작성자: <input type="text" name="b_writer" value="${board.b_writer}" readonly>
		제목: <input type="text" name="b_title" value="${board.b_title}">
		내용: <textarea name= "b_contentsl" rows="5"></textarea>
		<input type="submit" value="수정하기">
		</form>
</body>
</html>