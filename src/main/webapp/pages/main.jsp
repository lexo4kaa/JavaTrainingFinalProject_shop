<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 17.03.2021
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>

<h3>Welcome, ${user}!</h3>
<hr/>

<form name="findUsersByNickname" method="POST" action="controller">
    <input type="hidden" name="command" value="find_users_by_nickname" />
    <input type="text" name="nickname" value=""/>
    <input type="submit" value="Find all users by nickname (or part)" name="submit">
</form>

<form name="findUsers" method="POST" action="controller">
    <input type="hidden" name="command" value="find_all_users" />
    <input type="submit" value="Find all users" name="submit">
</form>
<hr/>

<br/>
<a href="controller?command=logout">Logout</a>
</body>
</html>
