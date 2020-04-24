<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HR Operations</title>
<link rel="stylesheet" href="./css/project.css">
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}
th {
  background-color: #4CAF50;
  color: white;
}

tr:nth-child(even) {background-color: #f2f2f2;}
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
<%-- Syntax: <c:forEach var="name of scoped variable" items="Colleciton,List or Array"> </c:forEach> --%>

<div style="overflow-x:auto;">
	<table>
		<tr>
			<th colspan="7" style="border-bottom:1px solid white; text-align:center">Projects List</th>
		</tr>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Manager</th>
			<th>Budget</th>
			<th>Status</th>
			<th colspan="2" style="text-align:center">Manipulations</th>
		</tr>
		<c:forEach var="project" items="${allProjects}">
		<tr>
			<td> <c:out value="${project.getProjectId()}"></c:out> </td>
			<td> <c:out value="${project.getProjectName()}"></c:out> </td>
			<td> <c:out value="${project.getProjectManager() }"></c:out> </td>
			<td> <c:out value="${project.getBudget() }"></c:out> </td>
			<td> <c:out value="${project.getStatus() }"></c:out> </td>
			
			<td><a href="updateProject?id=<c:out value='${project.getProjectId()}'></c:out>">Update</a></td>
			<td><a href="deleteProject?id=<c:out value='${project.getProjectId()}'></c:out>">Delete</a></td>
		</tr>
		
		</c:forEach>
	</table>
</div>
</body>
</html>