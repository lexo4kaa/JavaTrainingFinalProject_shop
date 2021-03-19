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
Result: ${numResult} <!-- numResult -- значение аттрибута из HelloServlet -->
<br/>
<table>
    <c:forEach var="elem" items="${lst}" varStatus="status">
        <tr>
            <td><c:out value="${ elem }" /></td>
            <td><c:out value="${ elem.id }" /></td>
            <td><c:out value="${ elem.text }" /></td>
            <td><c:out value="${ status.count }" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
