<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<jsp:include page="/common/header.jsp"/>
<h3>게시글 수정</h3>
<form action="../BoardUpdate.do" method="post">
번호 : <input type="text" name="seq" id="seq" value="${vo.seq }" /><br>
작성자 : <input type="text" name="id" id="id" value="${vo.id}" readonly/><br>
제목 : <input type="text" name="title" id="titld" value="${vo.title }"/><br>
내용 : <input type="text" name ="content" id="content" value="${vo.contents }"/><br>
<button type="submit">등록</button>
<button a href="BoardDelete.do?seq=${vo.seq }">삭제</button>
</form>
	
<%@include file = "/common/footer.jsp" %>
</body>
</html>