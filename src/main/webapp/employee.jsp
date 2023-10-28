<%@ page import="com.example.exam_practice.entities.EmployeeEntity" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/28/2023
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h2><a href="/employee-servlet">List Employee</a></h2><br>

<form action="employee-servlet" method="POST">
    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" required><br>
    <label for="birthday">BOD:</label>
    <input type="date" id="birthday" name="birthday" max="<%= LocalDate.now() %>" required><br>
    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required><br>
    <label for="position">Position:</label>
    <input type="text" id="position" name="position" required><br>
    <label for="department">Department:</label>
    <input type="text" id="department" name="department" required><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>


</body>
</html>
