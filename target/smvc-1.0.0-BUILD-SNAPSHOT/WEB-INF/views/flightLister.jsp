<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
	<title>Air controller Budapest</title>
</head>
<body>
<h1>  The planes flying right now: ${requestScope.planeCount} </h1>
<table>
	<c:foreach var="plane" item="${planes}">
	<tr><td>${plane.id}</td><td>${plane.name}</td></tr>
	</c:foreach>
</table>

</body>
</html>
