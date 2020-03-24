<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Sports</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<%@ include file="commonhead.jsp"%>
</head>
<body>

	<%@ include file="organizerMenu.jsp"%>
	<div class="container" style="margin: auto; width: 100%">
		<div class="col-md-6 col-md-offset-3 center">
			<div class="panel panel-login">
				<h1 align="center">Add Sports</h1>
				<f:form action="addSportsData" modelAttribute="sports" method="post">
					<table style="margin-left: 8%; width: 80%;">
						<tr>
							<td><f:label path="sportsName">Sports Name</f:label></td>
							<td><f:input path="sportsName" name="sportsName"
									class="field" placeholder="Enter Sports Name" /></td>
						</tr>
						<tr>
							<td></td>

							<td><span style="color: red"><f:errors
										path="sportsName"></f:errors></span></td>

						</tr>
						<tr>
							<td><f:label path="sportsType">Sports Type</f:label></td>
							<td><f:select path="sportsType" name="sportType"
									class="field">
									<f:option value="" selected="true" disabled="true">--Sports Type--</f:option>
									<f:option value="indoor">Indoor</f:option>
									<f:option value="outdoor">Outdoor</f:option>
								</f:select></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="sportsType"></f:errors></span></td>
						</tr>
						<tr>
							<td><f:label path="noOfPlayers">No Of Players</f:label></td>
							<td><f:input path="noOfPlayers" class="field"
									placeholder="Enter No of players" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="noOfPlayers"></f:errors></span></td>
						</tr>
						<tr>
							<td><f:label path="timeOfMatch">Time Of Match</f:label></td>
							<td><f:input path="timeOfMatch" class="field"
									placeholder="Enter time of match(HH:MM)" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="timeOfMatch"></f:errors></span></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" id="SubmitButton"
								value="Add Sports" /></td>
						</tr>

					</table>
				</f:form>
			</div>
		</div>
	</div>
</body>
</html>
