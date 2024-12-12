<%--
  Created by IntelliJ IDEA.
  User: ThinkpadX1
  Date: 12/12/2024
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi Tiết Nhân Viên</title>
</head>
<body>
<h1>Chi Tiết Nhân Viên</h1>
<p><strong>ID:</strong> ${employee.id}</p>
<p><strong>Tên:</strong> ${employee.name}</p>
<p><strong>Tuổi:</strong> ${employee.age}</p>
<p><strong>Phòng Ban:</strong> ${employee.department}</p>
<p><strong>Chức Vụ:</strong> ${employee.position}</p>
<p><strong>Lương:</strong> ${employee.salary}</p>
<br>
<a href="employee?action=list">Quay lại danh sách</a>

</body>
</html>
