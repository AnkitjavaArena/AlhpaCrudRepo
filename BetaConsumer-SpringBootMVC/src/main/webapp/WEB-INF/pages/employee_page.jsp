<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<c:choose>
		<c:when test="${!empty empData }">
			<h1 style="color: red; text-align: center">Employee Data</h1>
			<table class="table table-hover">

				<thead class="thead-dark">
					<tr>
						<th scope="col">EID</th>
						<th scope="col">EName</th>
						<th scope="col">Organization</th>
						<th colspan="2">Operation</th>
					</tr>
				</thead>
				
				
			
    
  
				
			<tbody>	
				<c:forEach var="emp" items="${empData}" >
					<tr>
				
						<th scope="row">${emp.employeeId }</th>
						<td>${emp.employeeName }</td>
						<td>${emp.organisation }</td>
						<td><a href="edit?id=${emp.employeeId }">Edit</a></td>
						<td><a href="delete?id=${emp.employeeId }">Delete</a></td>
					</tr>
					
				</c:forEach>
				</tbody>
			</table>
		</c:when>

		<c:otherwise>
			<h1 style="color: red; text-align: center">Employee Not Found</h1>
		</c:otherwise>
	</c:choose>

	   <br> 
     <h2  style="text-align:center"><a href="add"> Add Tourist </a>  </h2>
     
     <bR><bR>
         <h1 style="color:red;text-align:center"> ${resultMsg}  </h1>


</body>
</html>