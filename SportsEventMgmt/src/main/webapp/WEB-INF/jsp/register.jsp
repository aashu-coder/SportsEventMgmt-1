<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div class="container" style="margin: auto; width: 100%">
		<div class="col-md-6 col-md-offset-3 center">
			<div class="panel panel-login">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-6 col-md-4 col-lg-4">
							<a href="#" class="active" id="login-form-link">Login</a>
						</div>
						<div class="col-xs-6 col-md-4 ol-lg-4">
							<a href="#" id="register-form-link">Register</a>
						</div>
					</div>
					<hr>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">

							<form id="login-form" action="authenticateUser" method="post"
								role="form" style="display:${display1};">
								<div class="form-group">
									<input id="username" type="email" name="emailId" required=""
										tabindex="1" class="form-control" placeholder="Username"
										autofocus="" />
								</div>
								<div class="form-group">
									<input type="password" name="password" required=""
										id="password" tabindex="2" class="form-control"
										placeholder="Password" />
								</div>
								<div class="form-group text-center">
									<input type="checkbox" tabindex="3" value="yes" class=""
										name="remember" id="remember" /> <input type="checkbox"
										tabindex="3" value="no" class="" name="remember" id="hidden"
										checked /> <label for="remember" style="color: #ddd">
										Remember Me</label>
								</div>
								<div class="form-group">
									<div class="col-sm-6 col-sm-offset-3 col-lg-12">
										<input type="submit" name="login-submit" id="login-submit"
											tabindex="4" class="form-control btn btn-login"
											value="Log In">
									</div>
									<span style="color: red">${status}</span><br> <span
										style="color: red">${errMsg}</span>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-lg-12">
											<div class="text-center">
												<a href="forgotPassword" tabindex="5"
													class="forgot-password" style="color: #ddd">Forgot
													Password?</a>
											</div>
										</div>
									</div>
								</div>
							</form>
							<f:form action="registerUser" id="register-form"
								modelAttribute="user" method="post" style="display:${display2}">
								<div class="form-group">
									<f:select path="userType" class="form-control">
										<f:option value="" selected="true" disabled="true">--Select User--</f:option>
										<f:option value="organizer">Organizer</f:option>
										<f:option value="coach">Coach</f:option>
									</f:select>
									<td><span style="color: red"><f:errors
												path="userType"></f:errors>
								</div>
								<div class="form-group">
									<f:input path="firstName" placeholder="Enter First Name"
										class="form-control" required="" />
									<span style="color: red"><f:errors path="firstName"></f:errors></span>
								</div>
								<div class="form-group">
									<f:input path="lastName" placeholder="Enter Last Name"
										class="form-control" required="" />
									<td><span style="color: red"><f:errors
												path="lastName"></f:errors></span>
								</div>
								<div class="form-group">
									<f:input path="emailId" class="form-control"
										placeholder="Enter Email" required="" />
									<span style="color: red"><f:errors path="emailId"></f:errors></span>
								</div>
								<div class="form-group">
									<f:input placeholder="Enter Contact Number "
										path="contactNumber" class="form-control" required="" />
									<span style="color: red"><f:errors path="contactNumber"></f:errors></span>
								</div>
								<div class="form-group">
									<f:input path="age" placeholder="Enter Age"
										class="form-control" required="" />
									<span style="color: red"><f:errors path="age"></f:errors></span>
								</div>
								<div>
									<label class="radio-inline form-group"><f:radiobutton
											path="gender" value="male" required="" />Male</label> <label
										class="radio-inline"><f:radiobutton path="gender"
											value="female" required="" />Female</label> <label
										class="radio-inline"><f:radiobutton path="gender"
											value="others" required="" />Others</label><br> <span
										style="color: red"><f:errors path="gender"></f:errors></span>
								</div>

								<div class="form-group">
									<f:password path="password" placeholder="Enter Password"
										class="field" required="" />
									<span style="color: red"><f:errors path="password"></f:errors></span>
								</div>
								<div class="form-group">
									<div class="col-sm-6 col-sm-offset-3 col-lg-12 ">
										<input type="submit" name="register-submit"
											id="register-submit" tabindex="4"
											class="form-control btn btn-register" value="Register Now">
									</div>
								</div>
							</f:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
