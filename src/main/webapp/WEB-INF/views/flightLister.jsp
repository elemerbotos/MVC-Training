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
	<tr><th>ID</th><th>NAME</th><th>FUEL</th></tr>
<c:forEach var="plane" items="${planes}">
	<tr><td>${plane.id}</td><td>${plane.name}</td><td>${plane.fuel}</td></tr>
</c:forEach>
</table>

<br><br>
<div name="addPlane">
<form role="form" action="/smvc/planeShoutout/planes/add" method="POST">
	<label>Name: </label><br>
	<input type="text" name="name" value="${planeForm.name}"/><br>
	<label>ID: </label><br>
	<input type="number" name="id" value="${planeForm.id}"/><br>
	<label>Fuel: </label><br>
	<input type="number" name="fuel" value="${planeForm.fuel}"/><br>
	<button type="submit">ADD</button>
	
</form>
</div>

<br>
<table class="table">
	<tr><th>Name</th><th>Time Zone</th></tr>
<c:forEach var="city" items="${cities}">
	<tr><td>${city.name}</td><td>${city.timeZone}</td></tr>
</c:forEach>
</table>

<br><br>

<div name="addCity">
<form role="form" action="/smvc/planeShoutout/planes/addCity" method="POST">
	<label>Name: </label><br>
	<input type="text" name="name" value="${cityForm.name}"/><br>
	<label>Time Zone (compared to GMT): </label><br>
	<input type="number" name="timeZone" value="${cityForm.timeZone}"/><br>
	<button type="submit">ADD</button>
</form>
</div>

<br>
<table class="table">
	<tr><th>From</th>
		<th>To</th>
		<th>Length</th>
		<th>Plane fuel neccessary</th></tr>
<c:forEach var="route" items="${routes}">
	<tr><td>${route.from.name}</td>
		<td>${route.to.name}</td>
		<td>${route.lenght}</td>
		<td>${route.fuelNecessary}</td></tr>
	<c:forEach var="city" items="${route.vias}">
		<tr><td colspan="4">${city.name}</td></tr>
	</c:forEach>
</c:forEach>
</table>

<div name="addRoute"> 
<form role="form" action="/smvc/planeShoutout/planes/addRoute" method="POST">
	<label>From: </label><br>
	<select name="from">
	<c:forEach var="city" items="${cities}">
		<option value="${city.name}">${city.name}</option>
	</c:forEach>
	</select>
	<br>
	<label>From: </label><br>
	<select name="to">
	<c:forEach var="city" items="${cities}">
		<option value="${city.name}">${city.name}</option>
	</c:forEach>
	</select>
	<br>
	<label>Length: </label><br>
	<input type="number" name="length" value="${routeForm.length}"/><br>
	<label>Fuel neccessary </label><br>
	<input type="number" name="fuel" value="${routeForm.fuel}"/><br>
	<button type="submit">ADD</button>
</form>
</div>

<h2><a href="/smvc/planes/playGame">Go to plane controller site</a></h2>
</div>
<div class="col-md-2"></div>
</div>

 <br>
 
 <div id="gameDiv">
 </div>
<!--  <button id="play-button" onclick="playGame()">PLAY GAME</button> -->
 
</body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="/smvc/resources/js/planes.js"></script>
</html>
