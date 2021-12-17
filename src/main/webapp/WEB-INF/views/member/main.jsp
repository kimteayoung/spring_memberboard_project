<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logout(){
		location.href="logout";
	}
</script>
</head>
<body>
<h2>main.jsp</h2>
어서오세요 ${sessionScope.loginId} 님
<!-- 로그아웃 버튼을 클릭하면 logout 이라는 주소 요청 -->
<button onclick="logout()">로그아웃</button><br>

<c:if test="${sessionScope.loginId eq 'admin'}">
<a href="/member/admin">회원목록(관리자만 보여요)</a> 
</c:if>


</body>
</html>