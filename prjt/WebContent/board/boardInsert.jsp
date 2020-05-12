<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<jsp:include page="/common/header.jsp"></jsp:include>
<h3>게시글 작성</h3>
작성자 : <input type="text" name="name" id="name" ReadOnly><br>
제목 : <input type="text" name="title" id="titld"><br>
내용 : <input type="textarea" name ="content" id="content"><br>
<button type="submit">글쓰기</button>
<%@include file = "/common/footer.jsp" %>

</body>
</html>