<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Hello From service unavilable.jsp
<br>
Message from request attribute
<br>
<h1>
 <%String name=(String)request.getAttribute("response");
out.print(name+"<br>");
%>
</h1>
 

</body>
</html>