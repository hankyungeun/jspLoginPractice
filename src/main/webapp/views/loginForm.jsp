<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy Day 로그인</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<main>
    <h1>Happy Day</h1>
    <div class="login">
        <form action="/Practice01/login" method="get">
            <input type="text" name="id" placeholder="아이디">
            <br>
            <input type="password" name="passwd" placeholder="비밀번호">
            <br>
            <button type="submit">로그인</button>
        </form>
    </div>
</main>
</body>
</html>