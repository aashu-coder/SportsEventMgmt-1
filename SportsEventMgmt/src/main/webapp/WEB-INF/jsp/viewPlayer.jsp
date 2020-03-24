<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Player</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<%@ include file="commonhead.jsp"%>
</head>
<body>

	<%@ include file="coachMenu.jsp"%>
	<div class="container" style="margin: auto; width: 100%">
		<div class="viewTable">
			<div class="panel panel-login">
				<h1 align="center">View Players</h1>
				<div id="view">
					<table class="table table-bordered" id="tables">
						<tr>

							<th>Player Id</th>
							<th>Coach Id</th>
							<th>Player name</th>
							<th>Email Id</th>
							<th>contact Number</th>
							<th>Age</th>
							<th>Gender</th>
							<th>Action1</th>
							<th>Action2</th>

						</tr>
						<c:forEach var="p" items="${plist}">
							<tr>

								<td>${p.pId}</td>

								<td>${p.cId}</td>

								<td>${p.playerName}</td>

								<td>${p.emailId}</td>

								<td>${p.contactNumber}</td>

								<td>${p.age}</td>

								<td>${p.gender}</td>

								<td><a href="updatePlayer?pId=${p.pId}">update</a></td>

								<td><a href="deletePlayer?pId=${p.pId}">Delete</a></td>
							</tr>
						</c:forEach>

					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>