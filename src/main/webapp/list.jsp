<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/28/2023
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<h2><a href="/employee.jsp">Add Employee</a></h2><br>
    <table>
        <tr>
            <th>Id</th>
            <th>Full Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Position</th>
            <th>Department</th>

        </tr>

        <c:forEach var="employee" items="${employees}" varStatus="loop">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.fullName}</td>
                <td>${employee.birthday}</td>
                <td>${employee.address}</td>
                <td>${employee.position}</td>
                <td>${employee.department}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
