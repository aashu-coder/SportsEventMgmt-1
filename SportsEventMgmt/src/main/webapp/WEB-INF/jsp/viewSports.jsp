<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="commonhead.jsp"%>
<title>View Sports</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<%@ include file="commonhead.jsp"%>
</head>
<body>

	<%@ include file="organizerMenu.jsp"%>
	<div class="container" style="margin: auto; width: 100%">
		<div class="viewTable">
			<div class="panel panel-login">
				<h1 align="center">View Sports</h1>
				<div id="view">
					<table class="table table-bordered" id="tables">
						<tr>

							<th>Sports Name</th>
							<th>Sports Type</th>
							<th>No of Players</th>
							<th>Time of Match</th>
							<th>Action</th>
							<th>Action</th>

						</tr>
						<c:forEach var="s" items="${slist}">
							<tr>

								<td>${s.sportsName}</td>

								<td>${s.sportsType}</td>

								<td>${s.noOfPlayers}</td>

								<td>${s.timeOfMatch}</td>

								<td><a href="/updateSports?id=${s.sId}">update</a></td>

								<td><a href="deleteSports?sId=${s.sId}">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
