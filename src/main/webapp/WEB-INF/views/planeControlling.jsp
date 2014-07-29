<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Air controller Budapest</title>
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div class="row">
<div class="col-md-2">
</div>
<div class="col-md-8">
<h1>  The planes flying right now </h1>

<table class="table">
	<tr>
		<th>Plane id</th>
		<th>Plane Name</th>
		<th>Fuel</th>
		<th>Route id</th>
		<th>From</th>
		<th>To</th>
	</tr>
<c:forEach var="flight" items="${flights}">
	<tr>
		<td>${flight.plane.id}</td>
		<td>${flight.plane.name}</td>
		<td>${flight.plane.fuel}</td>
		<td>${flight.route.id}</td>
		<td>${flight.route.from}</td>
		<td>${flight.route.to}</td>
	</tr>
</c:forEach>
</table>

<br><br>

<table class="table">
	<tr><th>id</th><th>Name</th><th>Fuel</th></tr>
<c:forEach var="plane" items="${planes}">
	<tr><td>${plane.id}</td><td>${plane.name}</td><td>${plane.fuel}</td></tr>
</c:forEach>
</table>

<br><br>

<table class="table">
	<tr><th>Id</th>
		<th>From</th>
		<th>To</th>
		<th>Length</th>
		<th>Plane fuel neccessary</th></tr>
<c:forEach var="route" items="${routes}">
	<tr><td>${route.id}</td>
		<td>${route.from.name}</td>
		<td>${route.to.name}</td>
		<td>${route.lenght}</td>
		<td>${route.fuelNecessary}</td></tr>
	<c:forEach var="city" items="${route.vias}">
		<tr><td colspan="4">${city.name}</td></tr>
	</c:forEach>
</c:forEach>
</table>

<form action="/smvc/planeControlling/addAnotherRoute" method="POST">
	<label>Add route: </label><br>
	<select name="routeId">
	<c:forEach var="route" items="${routes}">
		<option value="${route.id}">${route.id}</option>
	</c:forEach>
	</select>
	<button type="submit">ADD</button>
	<br>
</form>

<form action="/smvc/planeControlling/addAnotherPlane" method="POST">	
	<label>Add plane: </label><br>
	<select name="planeId">
	<c:forEach var="plane" items="${planes}">
		<option value="${plane.id}">${plane.id}</option>
	</c:forEach>
	</select>
	<button type="submit">ADD</button>
	<br>
</form>
	
</div>
<div class="col-md-2"></div>
</div>
 
</body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="/smvc/resources/js/planes.js"></script>
</html>
