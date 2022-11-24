<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="css/style_home.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<table class="table table-hover">

		<thead class="thead-dark">
			<tr>
				<th>Welcome To Project Beta!!!</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>
					<h3>
						<a href="showAllEmployee">Display All Employees</a>
					</h3>
				</td>
			<tr>
			<tr>
				<td>
					<h3>
						<a href="search">Search Employee</a>
					</h3>
				</td>
			<tr>
			<tr>
				<td>
					<h3>
						<a href="getDelete">Delete By Employee ID</a>
					</h3>
				</td>
			<tr>
			<tr>
				<td>
					<!-- generating delete double confirmation message using javascript-->
					<h3>
						<a onclick="return confirm('Do you want to delete all Records')"
							href="deleteAll">Delete All</a>
					</h3>
				</td>
			<tr>
			<tr>
				<td>
					<h3>
						<a href="updateOrg">Update Orgainsation</a>
					</h3>
				</td>
			<tr>
		</tbody>




	</table>

</body>
</html>