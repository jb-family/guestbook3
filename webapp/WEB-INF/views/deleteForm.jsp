<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	
	<form method="get" action="/guestbook3/delete">
	비밀번호 <input type="password" name ="password"><button type="submit">확인</button>
	<input type="text" name="no" value= "${param.no}">
	</form>
	<a href="/guestbook3/addList">메인으로 돌아가기</a>
</body>
</html>