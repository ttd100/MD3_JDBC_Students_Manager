<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>----------Student Manager---------</h1>
<a href="/student?action=create">Create</a>
<form method="post">
    <input type="text" name="search">
    <button type="submit">Search</button>
    <a href="/">Back menu</a>
</form>
<table border="1" style="width: 50%">
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach var="st" items='${requestScope["listStudent"]}'>
        <tr>
            <td><a href="students?action=detail&id=${st.id}">${st.id}</a></td>
            <td>${st.name}</td>
            <td>${st.age}</td>
            <td>
                <a href="students?action=edit&id=${st.id}">Edit</a>
            </td>
            <td>
                <a href="students?action=delete&id=${st.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>