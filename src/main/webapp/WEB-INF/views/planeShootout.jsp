<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Air controller Budapest</title>
</head>
<body>
<h1>  The planes flying right now: ${requestScope.planeCount} </h1>
<table>
<c:forEach var="plane" items="${planes}">
	<tr><td>${plane.id}</td><td>${plane.name}</td></tr>
</c:forEach>
</table>

</body>
</html>
