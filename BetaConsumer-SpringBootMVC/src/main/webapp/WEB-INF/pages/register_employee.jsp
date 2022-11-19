<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Employee</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-color: gray;">

	<h1 style="color: red; text-align: center;">Register Employee</h1>

	<frm:form modelAttribute="empData" method="post" action="add">
		<table class="table table-hover table-info" >
			<tr >
				<td >Employee Name:</td>
				<td><frm:input path="employeeName" /></td>
			</tr>
			<tr>
				<td>Employee's Organization</td>
				<td><frm:input path="organisation" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register Employee">
			</tr>
		</table>

	</frm:form>

</body>