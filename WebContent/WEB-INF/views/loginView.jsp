<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HR Operations</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>

	<div class="container">
  <div class="login">
    <h1>Admin Login</h1>
    <form method="post" action="${pageContext.request.contextPath}/login">
      <p><input type="text" name="email" value="" placeholder="Username or Email"></p>
      <p><input type="password" name="password" value="" placeholder="Password"></p>
     
      <p class="submit"><input type="submit" name="submit" value="Login"></p>
      <c:if test="${not empty error}">
 <div><h1 style="background-color:orangered;color:white;">  <c:out value="${error}"/> </h1></div>
</c:if>
    </form>
  </div>
 
  <div class="login-help">
    <p>Forgot your password? <a href="#">Click here to reset it</a>.</p>
  </div>
</div>






</body>
</html>