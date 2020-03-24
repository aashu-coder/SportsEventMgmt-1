<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event Participation</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<%@ include file="commonhead.jsp"%>
</head>
<body>

	<%@ include file="coachMenu.jsp"%>
	<div class="container" style="margin: auto; width: 100%">
		<div class="viewTable">
			<div class="panel panel-login">
				<h1 align="center">Event Participation</h1>
				<div id="view">
					<table class="table table-bordered" id="tables">
						<tr>
							<th>Event Id</th>
							<th>Event Name</th>
							<th>Sports Name</th>
							<th>Date of Event</th>
							<th>Time of Event</th>
							<th>No of Slots</th>
							<th>Action</th>
						</tr>
						<c:forEach var="e" items="${elist}">
							<tr>
								<td>${e.eId}</td>

								<td>${e.eventName}</td>

								<td>${e.sportsName}</td>

								<td>${e.eventDate}</td>

								<td>${e.eventTime}</td>

								<td>${e.noOfSlots}</td>

								<td><a href="updateEvent?eId=${e.eId}">Participate</a></td>


							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>