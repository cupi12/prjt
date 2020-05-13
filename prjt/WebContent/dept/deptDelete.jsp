<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>부서 삭제</title>
</head>
<body>
<h3>부서 삭제페이지</h3>
<form action="DeptDelete.do" method="post">
department_id : <input type="text" name ="department_id" id="department_id" value="${vo.department_id }" readonly><br>
department_name : <input type="text" name = "department_name" id ="department_name" value="${sessionScope.department_name }" readonly><br>
manager_id : <input type="text" name = "manager_id" id ="manager_id" value="${sessionScope.manager_id }" readonly><br>
location_id : <input type="text" name = "location_id" id ="location_id" value="${sessionScope.location_id }" readonly><br>
<input type="submit" value="삭제">
</form> 
</body>
</html>