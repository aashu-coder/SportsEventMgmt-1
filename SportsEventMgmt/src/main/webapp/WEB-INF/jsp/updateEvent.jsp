<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Events</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<%@ include file="commonhead.jsp"%>
</head>
<body>

	<%@ include file="organizerMenu.jsp"%>
	<div class="container" style="margin: auto; width: 100%">
		<div class="col-md-6 col-md-offset-3 center">
			<div class="panel panel-login">
				<h1 align="center">Update Event</h1>
				<f:form action="updateEventData" modelAttribute="event"
					method="post">
					<table style="margin-left: 8%; width: 80%;">
						<f:hidden path="eId" name="eId" />
						<tr>
							<td><f:label path="eventName">Event Name</f:label></td>
							<td><f:input path="eventName" readonly="true" autofocus=""
									name="eventName" placeholder="Enter Event Name"
									value="${event.eventName}" class="field" required="" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="eventName"></f:errors></span></td>

						</tr>


						<tr>
							<td><f:label path="sportsName">Sports Name</f:label></td>
							<td><f:input path="sportsName" readonly="true" autofocus=""
									name="sportsName" placeholder="Enter Sports Name"
									value="${event.sportsName}" class="field" required="" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="sportsName"></f:errors></span></td>
						</tr>


						<tr>
							<td><f:label path="eventDate">Event Date</f:label></td>
							<td><f:input path="eventDate"
									placeholder="Enter Event Date(dd-mm-yyyy)"
									value="${event.eventDate}" autofocus="" class="field"
									required="" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="eventDate"></f:errors></span></td>
						</tr>
						<tr>

							<td><f:label path="eventTime">Event Time</f:label></td>
							<td><f:input path="eventTime"
									placeholder="Enter Event Time(HH:MM)"
									value="${event.eventTime}" autofocus="" class="field"
									required="" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="eventTime"></f:errors></span></td>
						</tr>
						<tr>
							<td><f:label path="noOfSlots">Number of slots </f:label></td>
							<td><f:input path="noOfSlots"
									placeholder="Enter Number of slots" autofocus="" class="field"
									value="${event.noOfSlots}" required="" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span style="color: red"><f:errors
										path="noOfSlots"></f:errors></span></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" id="SubmitButton"
								value="Update Event" /></td>

						</tr>
					</table>
				</f:form>
			</div>
		</div>
	</div>
</body>
</html>
