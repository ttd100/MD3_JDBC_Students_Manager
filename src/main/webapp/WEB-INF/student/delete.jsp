<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/9/2022
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test='${requestScope["message"]!= null}'>
    <span style="color:blue">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label>Name</label><br>
    <input value="${requestScope["students"].getName()}"><br>
    <label>Age</label><br>
    <input value="${requestScope["students"].getAge()}"><br>
    <p>ARE YOU SURE DELETE</p>
    <button>YES</button>
</form>
<a href="/"><button>NO back menu</button></a>
</body>
</html>
