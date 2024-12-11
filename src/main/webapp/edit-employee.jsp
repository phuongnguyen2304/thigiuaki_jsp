
<%--
  Created by IntelliJ IDEA.
  User: ThinkpadX1
  Date: 12/11/2024
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập Nhật Nhân Viên</title>
</head>
<body>
<h1>Cập Nhật Thông Tin Nhân Viên</h1>
<form action="employee?action=update" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    <label for="name">Tên:</label>
    <input type="text" name="name" id="name" value="${employee.name}" required><br>
    <label for="age">Tuổi:</label>
    <input type="number" name="age" id="age" value="${employee.age}" required><br>
    <label for="department">Phòng ban:</label>
    <input type="text" name="department" id="department" value="${employee.department}" required><br>
    <label for="position">Chức vụ:</label>
    <input type="text" name="position" id="position" value="${employee.position}" required><br>
    <label for="salary">Lương:</label>
    <input type="number" name="salary" id="salary" step="0.01" value="${employee.salary}" required><br>
    <button type="submit">Cập nhật</button>
</form>

</body>
</html>
