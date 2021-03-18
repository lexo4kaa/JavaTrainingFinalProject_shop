<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Приветствую!
</h1>
<br/>
<form action="helloservlet" method="post">
    <input type="text" name="number" value=""> <!-- текстовое поле -->
    <br/>
    <input type="submit" name="submit" value="push" > <!-- кнопка -->
</form>
<hr/>
<a href="helloservlet">Hello Servlet</a>
</body>
</html>