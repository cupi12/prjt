<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@include file = "/common/header.jsp" %>
<form action="/edu/Login.do" method="post">
<input name="id" placeholder="id"><br>
<input name="pwd" placeholder="pwd" type="password"><br>
<button>로그인</button><br>

<%@include file = "/common/footer.jsp" %>
</body>
</html>