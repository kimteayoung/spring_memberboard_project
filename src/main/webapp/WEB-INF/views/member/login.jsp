<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>login.jsp</h2>
<form action="/member/login" method="post">
	아이디: <input type="text" name="m_id"><br> 
	비밀번호: <input type="password" name="m_pw"> <br>
	<input type="submit" value="로그인"> 
</form>
</body>
</html>