<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/9/2022
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Back Menu</a><br>
<label>Id</label><br>
<input type="text" name="name" value="${requestScope["students"].getName()}" ><br>
<label>Name</label>
<input type="text" name="name" value="${requestScope["students"].getName()}" ><br>
<label>Age</label><br>
<input type="text" name="age" value="${requestScope["students"].getAge()}" ><br>

</body>
</html>
