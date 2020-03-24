
<%
	Integer coachid = (Integer) session.getAttribute("cid");
	int id = (int) coachid;
%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Player</title>
<%@ include file="commonhead.jsp"%>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="coachMenu.jsp"%>
	<div class="container" style="margin: auto; width: 100%">
		<div class="col-md-6 col-md-offset-3 center">
			<div class="panel panel-login">
				<h1 align="center">Update Player</h1>
				<f:form action="updatePlayerData" modelAttribute="player"
					method="post">
					<table style="margin-left: 8%; width: 80%;">
						<f:hidden path="pId" name="pId" />
						<tr>
							<td><f:hidden path="cId" class="field" name="cId" /></td>
						</tr>
						<tr>
							<td><f:label path="playerName">Player Name</f:label></td>
							<td><f:input path="playerName"
									placeholder="Enter Player Name" value="${player.playerName}"
									autofocus="" class="field" required="" readonly="true" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="playerName"></f:errors></span></td>
						</tr>

						<tr>
							<td><f:label path="emailId">Email Id</f:label></td>
							<td><f:input path="emailId" placeholder="Enter Email Id"
									value="${player.emailId}" class="field" required="" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors path="emailId"></f:errors></span></td>
						</tr>
						<tr>
							<td><f:label path="contactNumber">Contact Number</f:label></td>
							<td><f:input placeholder="Enter Contact Number"
									path="contactNumber" value="${player.contactNumber}"
									class="field" required="" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="contactNumber"></f:errors></span></td>
						</tr>
						<tr>
							<td><f:label path="age">Age</f:label></td>
							<td><f:input path="age" placeholder="Enter Age"
									value="${player.age}" class="field" required="" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors path="age"></f:errors></span></td>
						</tr>
						<tr>
							<td><f:label path="gender">Gender</f:label></td>
							<td><f:radiobutton path="gender" value="${player.gender}"
									required="" />Male <f:radiobutton path="gender"
									value="${player.gender}" required="" />Female <f:radiobutton
									path="gender" value="${player.gender}" required="" />Others</td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors path="gender"></f:errors></span></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" id="SubmitButton"
								value="Update Player" /></td>
							<td></td>
						</tr>
					</table>

				</f:form>
			</div>
		</div>
	</div>
</body>
</html>