<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Organisation</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

<form action="modifyOrganisation" method="get">
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Employee ID</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" name="id" placeholder="Employee Id" >
    </div>
    <br>
</div>

<div class="form-group row">
    <label for="inputOrganisation" class="col-sm-2 col-form-label">Employee Organisation</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="organisation" placeholder="Employee's New Organisation" >
    </div>
    <br>
</div>
  <input type="submit" value="Submit" >
</form>

</body>
</html>