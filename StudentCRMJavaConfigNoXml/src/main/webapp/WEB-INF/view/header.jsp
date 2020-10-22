<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
<title>List Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mystyle.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/offcanvas.css" /><!--request.getContextPath() %> ${pageContext.request.contextPath} -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/floating-labels.css" />

<!-- JQuery DataTable Css -->
<link  type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/dtable/datatables.net-bs4/css/dataTables.bootstrap4.css" >
</head>
<body >
<header>
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark ">

  <a class="navbar-brand mr-auto mr-lg-0" href="#">Customer CRM</a>
  <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
    <div class="container">
  <div class="row"> 
    <ul class="navbar-nav mr-auto nav-pills flex-column flex-sm-row">
      <li class="nav-item active ">
        <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown nav-pills flex-column flex-sm-row">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Customer</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="list">View Customers</a>
          <security:authorize access="hasAnyRole('MANAGER','ADMIN')">
          <a class="dropdown-item" href="showCustomerFormForAdd">Add Customers</a>
          </security:authorize>
         
        </div>
      </li>
      <li class="nav-item  ">
         <form:form action="${pageContext.request.contextPath}/logout" 
							   method="POST" class="form-horizontal">
<!-- Login/Submit Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-success">Logout</button>
							</div>
						</div>
</form:form>
      </li>
      
    </ul>
  </div>
  </div>
  </div> 
</nav>
</header>
</body>
</html>