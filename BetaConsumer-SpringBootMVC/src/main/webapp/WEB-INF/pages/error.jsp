<%@ page language="java"  isELIgnored="false" %>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<h1 style="color:red;text-align:center"> Sorry for the inconveince..(error.jsp)</h1>
 <table class="table table-hover table-info"  border="1" align="center" bgcolor="cyan">
     <tr>
       <td> status </td>
       <td>${status}  </td>
     </tr>
    
     <tr>
       <td> name </td>
       <td>${name}  </td>
     </tr>
     
       <tr>
       <td>message</td>
       <td>${message}  </td>
     </tr>
     
       <tr>
       <td>timestamp </td>
       <td>${timestamp}  </td>
     </tr>
     
       <tr>
       <td>path</td>
       <td>${path} </td>
     </tr>
     
     <%--   <tr>
       <td>trace</td>
       <td>${trace} </td>
     </tr>
      --%>
     
     
 </table>