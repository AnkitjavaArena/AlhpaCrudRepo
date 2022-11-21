<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<h1 style="color: red; text-align: center">Edit Tourist</h1>

	<frm:form modelAttribute="empData" method="post" action="edit">
		<table>
			<tr>
				<td>Employee Id::</td>
				<td><frm:input path="employeeId" readonly="true" /></td>
			</tr>
			<tr>
				<td>Employee Name::</td>
				<td><frm:input path="employeeName" />
				<frm:errors  path="employeeName" cssStyle="color:red"/>
				<span id="enameErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee's Organisation::</td>
				<td><frm:input path="organisation" />
				<frm:errors  path="organisation" cssStyle="color:red"/>
				<span id="organisationErr"></span>
				
				
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>