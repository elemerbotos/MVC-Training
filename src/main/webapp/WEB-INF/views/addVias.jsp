<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Air controller Budapest</title>
</head>
<body>
<h1>  The planes flying right now </h1>

<table border="1" style="width: 30%">
	<tr><td>Name</td><td>Time Zone</td></tr>
<c:forEach var="city" items="${cities}">
	<tr><td>${city.name}</td><td>${city.timeZone}</td></tr>
</c:forEach>
</table>


<div name="routeForm">
<form role="via" action="/smvc/planeShoutout/planes/addVia" method="POST">
	<label>From: </label><br>
	<select name="vias">
	<c:forEach var="city" items="${cities}">
		<option value="${city.name}">${city.name}</option>
	</c:forEach>
	</select>
	<br>

	<button type="submit">ADD</button>
</form>

<%-- <form:form action="/smvc/planeShoutout/planes/addVia" method="POST"> --%>
<!-- 	<label>Via </label><br> -->
<%-- 	<form:select path="vias"> --%>
<%-- 		<form:option value="-" label="Please select a value"></form:option> --%>
<%-- 		<form:options items="${cities}" itemValue="name" /> --%>
<%-- 	</form:select> --%>
<%-- </form:form> --%>
</div>

	<a href="/smvc/planeShoutout/planes/addVia?step=done" >Finished</a>

</body>
</html>
