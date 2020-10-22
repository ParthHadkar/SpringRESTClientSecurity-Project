<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
.error{
color: red;
}
</style>
</head>
<body>
<h3>Login</h3>
<form:form action="${pageContext.request.contextPath }/autenticateUser" method="POST">
<p>
 <%-- <form:input path="username" placeholder="Enter your username" name="username"/>
<form:label path="username">Username</form:label> --%>
 Username: <input type="text" name="username"/> 
</p>
<p>
<%-- <form:password path="password" placeholder="Enter your password" name="password"/>
<form:label path="password" >Password</form:label> --%>
 Password: <input type="password" name="password"/> 
</p><!-- ${not empty SPRING_SECURITY_LAST_EXCEPTION.message} -->
<c:if  test="${param.error != null }">
<i class="error">Invalid Username OR Password!!!!<br/>${SPRING_SECURITY_LAST_EXCEPTION.message}</i>
<br/><br/>
</c:if>
<input type="submit" value="Login"/>
</form:form>

</body>
</html>