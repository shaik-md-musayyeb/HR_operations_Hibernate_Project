<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HR Operations</title>
<link rel="stylesheet" href="./css/project.css">
<style>


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
<%-- form starts from here --%>
<div class="container">
<h1>Add Project</h1>
</div>
<div class="container">
  <form method="post" action="${pageContext.request.contextPath}/addProject">
    <div class="row">
      <div class="col-25">
        <label for="projectName">Project Name</label>
      </div>
      <div class="col-75">
        <input type="text" name="projectName" placeholder="Project name..">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="managerName">Manager Name</label>
      </div>
      <div class="col-75">
        <input type="text" name="managerName" placeholder="Manager name..">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="budget">Budget</label>
      </div>
      <div class="col-75">
        <input type="text" pattern="[0-9\,]{10}" name="budget" placeholder="Budget..">
      </div>
    </div>
   <div class="row">
      <div class="col-25">
        <label for="status">Project Status</label>
      </div>
      <div class="col-75">
        <input type="text" name="status" placeholder="Status..">
      </div>
    </div>
    <div class="row">
      <input type="submit" value="Submit">
    </div>
  </form>
</div>

</body>
</html>