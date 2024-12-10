<%--
  Created by IntelliJ IDEA.
  User: ThinkpadX1
  Date: 12/10/2024
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Nhân Viên</title>
</head>
<body>
<h1>Thêm Nhân Viên Mới</h1>
<form action="employee?action=add" method="post">
    <label for="id">Mã Nhân Viên:</label>
    <input type="text" name="id" id="id" required><br>

    <label for="name">Họ và Tên:</label>
    <input type="text" name="name" id="name" required><br>

    <label for="age">Tuổi:</label>
    <input type="number" name="age" id="age" required><br>

    <label for="department">Phòng Ban:</label>
    <input type="text" name="department" id="department" required><br>

    <label for="position">Vị Trí:</label>
    <input type="text" name="position" id="position" required><br>

    <label for="salary">Mức Lương:</label>
    <input type="number" name="salary" id="salary" step="0.01" required><br>

    <button type="submit">Thêm Nhân Viên</button>
</form>
<a href="employee?action=list">Quay lại danh sách nhân viên</a>

</body>
</html>
