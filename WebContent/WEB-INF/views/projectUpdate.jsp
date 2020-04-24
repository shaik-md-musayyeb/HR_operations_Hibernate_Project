<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HR Operations</title>
<link rel="stylesheet" href="./css/project.css">

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
<h1>Update Project Details</h1>
</div>
<div class="container">
	<c:forEach var="proj" items="${project}">
		<form method="post" action="${pageContext.request.contextPath}/updateProject">
			
			<div class="row">
		      <div class="col-25">
		        <label for="id">Project Id</label>
		      </div>
		      <div class="col-75">
		        <input type="text" name="id" placeholder="Id.." value='<c:out value="${proj.getProjectId()}"></c:out>' readonly>
		      </div>
		    </div>
		    
		    <div class="row">
		      <div class="col-25">
		        <label for="projectName">Project Name</label>
		      </div>
		      <div class="col-75">
		        <input type="text" name="projectName" placeholder="Project name.." value='<c:out value="${proj.getProjectName()}"></c:out>'>
		      </div>
		    </div>
		    <div class="row">
		      <div class="col-25">
		        <label for="managerName">Manager Name</label>
		      </div>
		      <div class="col-75">
		        <input type="text" name="managerName" placeholder="Manager name.." value='<c:out value="${proj.getProjectManager()}"></c:out>'>
		      </div>
		    </div>
		    <div class="row">
		      <div class="col-25">
		        <label for="budget">Budget</label>
		      </div>
		      <div class="col-75">
		        <input type="text" name="budget" pattern="[0-9\,]{10}" placeholder="Budget.." title="Only numbers(0-9)" value='<c:out value="${proj.getBudget()}"></c:out>'>
		      </div>
		    </div>
		   <div class="row">
		      <div class="col-25">
		        <label for="status">Project Status</label>
		      </div>
		      <div class="col-75">
		        <input type="text" name="status" placeholder="Status.." value='<c:out value="${proj.getStatus()}"></c:out>'>
		      </div>
		    </div>
		    <div class="row">
		      <input type="submit" value="Submit">
		    </div>
  		</form>
	</c:forEach>

</div>

</body>
</html>