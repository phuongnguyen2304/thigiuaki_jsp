<%@ page import="java.util.List" %>
<%@ page import="model.Employee" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ThinkpadX1
  Date: 12/10/2024
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<%!

%><%
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee("ID001","Nguyên Phương",20,"Testing","Tester",8000));
    employeeList.add(new Employee("ID002","Ngọc Thơm",23,"Developer","Lập Trình",10000));
    employeeList.add(new Employee("ID003","Lan",25,"finance","Kế Toán",7500));
    employeeList.add(new Employee("ID004","Linh",28,"Designer","Marketing",15000));
    employeeList.add(new Employee("ID005","Thanh Nga",32,"Manager","Quản lý cấp cao",20000));
    request.setAttribute("employee-list",employeeList);

%>
<h1>Employee List</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Position</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <items>${employee}</items>
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.age}</td>
            <td>${employee.position}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>
                <a href="employee?action=view&id=${employee.id}">View</a>
                <a href="employee?action=edit&id=${employee.id}">Edit</a>
                <a href="employee?action=delete&id=${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
