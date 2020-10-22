<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
	
	<title>Register Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style type="text/css">
	.error{
	color: red;
	}
	</style>

</head>

<body>

	<div>
		
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Sign Up</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Login Form -->
					<form:form action="${pageContext.request.contextPath}/register/registerUser" 
							   method="POST" modelAttribute="CrmUser" class="form-horizontal">

					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>									
									<!-- Check for Registration error -->
	
								<c:if test="${registrationError != null}">		            
									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										${registrationError}
									</div>
								   </c:if>

					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							
							<form:input path="username" placeholder="username" class="form-control" />
							
						</div>
						<div>
							<form:errors path="username" cssClass="error"/>
							</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<form:password path="password" placeholder="password" class="form-control" />
							
						</div>
						<div>
							<form:errors path="password" cssClass="error"/>
							</div>
						<!-- Confirm Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<form:password path="confirmPassword" placeholder="confirm Password" class="form-control" />
							
						</div>
						<div>
							<form:errors path="confirmPassword" cssClass="error"/>
							</div>
						
						<!-- First Name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<form:input path="firstname" placeholder="first name" class="form-control" />
							
						</div>
						<div>
							<form:errors path="firstname" cssClass="error"/>
							</div>
						
						<!-- Last Name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<form:input path="lastName" placeholder="last name" class="form-control" />
							
						</div>
						<div>
							<form:errors path="lastName" cssClass="error"/>
							</div>
						
						<!-- EmailId -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<form:input path="emailId" placeholder="EmailId" class="form-control" />
							
						</div>
						<div>
							<form:errors path="emailId" cssClass="error"/>
							</div>
					
					<!-- Roles -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<form:select path="roles" placeholder="Roles" class="form-control" items="${roles}" multiple="true"/>
							
						</div>
						<div>
							<form:errors path="roles" cssClass="error"/>
							</div>
						<%--<!-- Manually add csrf token-->
						 <div style="margin-bottom: 25px" class="input-group">
							
							<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"  >
						</div> --%>

						<!-- Login/Submit Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</div>

					</form:form>
					
					

				</div>

			</div>

		</div>

	</div>

</body>
</html>