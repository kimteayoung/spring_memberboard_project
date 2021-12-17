<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>detail.jsp</h2>

글번호: ${member.m_number } <br>
아이디: ${member.m_id } <br>
비밀번호: ${member.m_pw } <br>
이름:  ${member.m_name } <br>
이메일: ${member.m_email } <br>

<a href="/member/admin">목록으로 돌아가기</a>

<a href="/">홈</a><!-- http://localhost:8081/ -->

</body>
</html>