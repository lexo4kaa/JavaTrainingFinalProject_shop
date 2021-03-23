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
    <title>Title</title>
</head>
<body>

<h3>Welcome!</h3>
<hr/>
${user}, hello!
<hr/>

Your ${numResult} triangles:
<br/>
<table border="1">
    <c:forEach var="elem" items="${lst}" varStatus="status">
        <tr>
            <td><c:out value="${ status.count }" /></td>
            <td><c:out value="${ elem }" /></td>
        </tr>
    </c:forEach>
</table>

<a href="controller?command=logout">Logout</a>

</body>
</html>
