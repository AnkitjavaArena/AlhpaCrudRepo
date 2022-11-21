/**
 * 
 */
 function validation(frm){
//empty the error messages
document.getElementById("employeeNameErr").innerHTML="";
document.getElementById("organisation").innerHTML="";

//read form data
let employeeName=frm.employeeName.value
let organisation=frm.organisation.value

let flag=true;
//form validations (client side)
if(employeeName==""){
	//ename required rule
	document.getElementsById('employeeNameErr").innerHTML="EmployeeName is mandatory(CS)";
	flag=false;
}

else if(employeeName.length>10){
	//ename amx length rule
	document.getElementsById("employeeNameErr").innerHTML="EmployeeName must not have more than 10 characters";
	flag=false;
}

if(organisation==""){
	//ename required rule
	document.getElementsById("organisationErr").innerHTML="EmployeeName is mandatory(CS)";
	flag=false;
}

else if(organisation.length>10){
	//ename amx length rule
	document.getElementsById("organisationErr").innerHTML="EmployeeName must not have more than 10 characters";
	flag=false;
}

	 return flag;
 }//end of fuction
 