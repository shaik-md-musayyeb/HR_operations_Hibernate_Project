<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HR Operations</title>
<link rel="stylesheet" href="./css/project.css">
<style>
div{
height:20em;
display:flex;
align-items: center;
justify-content: center;


}

</style>
</head>
<body>
<ul>

  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Employees</a>
    <div class="dropdown-content">
      <a href="#">Add Employee</a>
      <a href="#">View Employee Details</a>
    </div>
  </li>
  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Projects</a>
    <div class="dropdown-content">
      <a href="${pageContext.request.contextPath }/allProjects">View All Projects</a>
      <a href="${pageContext.request.contextPath }/addProject">Add Project</a> 
    </div>
  </li>
</ul>
<div ><h1>
Welcome Admin
</h1></div>

</body>
</html>