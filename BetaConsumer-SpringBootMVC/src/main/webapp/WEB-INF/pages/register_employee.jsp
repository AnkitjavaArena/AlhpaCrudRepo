<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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

<noscript>
    <h1 style="color:red;text-align:center">Please enable java script </h1>
</noscript>

 
	<h1 style="color: red; text-align: center;">Register Employee</h1>

	<form:form modelAttribute="empData" method="post" onsubmit="return validation(this)"   action="add" >
		<table class="table table-hover table-info" >
			<tr >
				<td >Employee Name:</td>
				<td><form:input path="employeeName" />
				<form:errors  path="employeeName" cssStyle="color:red"/>
				<span id="enameErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee's Organization</td>
				<td><form:input path="organisation" />
				<form:errors  path="organisation" cssStyle="color:red"/>
				<span id="organisationErr"></span>
				</td>
			</tr>

			<tr>
				<td><input type="submit" value="Register Employee">
			</tr>
		</table>
 <%-- <form:hidden path="vflag" /> --%>
	</form:form>\
	
	
	<!-- my javascript form validation failed -->
<!-- 
<script type="text/javascript">
	 document.write("Hello");
	 function  validation(frm){
		 alert("Client side form validations");
		 //empty the error messages
	      document.getElementById("employeeNameErr").innerHTML="";
	      document.getElementById("organisationErr").innerHTML="";
	      
	    //read form data
	     let employeeName=frm.employeeName.value;
	     let organisation=frm.organisation.value;
	   
	       let flag=true;
	    //form validations (client side)
	    if(employeeName==""){  //ename required rule
		    document.getElementById("employeeNameErr").innerHTML="employee name is mandatory(cs)";
	        flag=false;
	     } 
	  else if(employeeName.length>10){   //ename -max length rule
		   document.getElementById("employeeNameErr").innerHTML="employee name must have max of 10 chars(cs)";
	       flag=false;
	    }


	  if(organisation==""){   //org -required rule
		    document.getElementById("organisationErr").innerHTML="employee org is required(cs)";
	       flag=false;  
	    }
	  else if(organisation.length<3){  //job -max length rule
		   document.getElementById("organisationErr").innerHTML="organisation  must be more than 3 characters(cs)";
	     flag=false;  
	  }
	// change  vflag value to "yes" indicating client side form validations are done
	frm.vflag.value="yes";

	return flag;

	 </script>
 -->
</body>