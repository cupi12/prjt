<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<jsp:include page="/common/header.jsp"></jsp:include>
<form action="DeptUpdate.do" method="post">
department_id : <input type="text" name ="department_id" id="department_id" value="${vo.department_id }"><br>
department_name : <input type="text" name = "department_name" id ="department_name" value="${sessionScope.department_name }"><br>
manager_id : <input type="text" name = "manager_id" id ="manager_id" value="${sessionScope.manager_id }"><br>
location_id : <input type="text" name = "location_id" id ="location_id" value="${sessionScope.location_id }"><br>
<input type="submit" value="수정"><input type="reset" value="초기화">
</form>
<%@include file = "/common/footer.jsp" %>
</body>
</html>