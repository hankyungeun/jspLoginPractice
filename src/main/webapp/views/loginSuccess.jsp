<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.vo.Member"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main>
<%=loginUser.getName()%>님, 로그인에 성공했습니다.
</main>
</body>
</html>