<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
	<head>
		<title>SpringDemo Login</title>
		<meta content="width=device-width, initial-scale=1" name="viewport"/>
	
		<script type="text/javascript" src='js/jquery-1.11.0.min.js'></script>
		<script type="text/javascript" src='js/bootstrap.min.js'></script>
	
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="css/signin.css" type="text/css"/>
	</head>
	<body>
		<div class="container">
		<form:form action="registration.htm" commandName="registrationForm" method="post" cssClass="form-signin" name="registrationForm">
		 
	       <div class="control-group" align="center">
			 <img src="images/logo.png" alt="logoImg" class="img-circle img-responsive"/>
		</div> 
	        
			<div class="control-group"> 
			 	<label class="control-label" for="inputEmail" style="font-weight: normal;">Email</label>
				<div class="controls">
					<form:input path="email" type="text" id="inputEmail" placeholder="abc@gmail.com" cssClass = "form-control" autofocus="autofocus"/>
				</div>
				<form:errors path="email" cssClass = "error" id="emailerror"/>
			</div>
			
			<%-- <div class="control-group">	
				<label class="control-label" style="margin-top: 5px; font-weight: normal;">Role</label>	
				<div class="controls">		
					<form:radiobutton path="role" value="teacher"/>Teacher&nbsp;&nbsp;
					<form:radiobutton path="role" value="security"/>Security
				</div>	
				<form:errors path="role" cssClass = "error"/>
			</div> --%>
			
				<c:if test="${not empty loginFailed}">
					<div class="control-group error" align="center">email already exists with other role</div>
				</c:if>

			</br>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-lg btn-primary btn-block" value="Submit">Login</button>
				</div>
			</div>
	
		</form:form>
		</div>
	</body>
</html>
