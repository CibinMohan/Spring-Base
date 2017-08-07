<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>
Add Book
</h3>
<br>
<sf:form commandName="user" action ="/Test2/saveUser">
id = <sf:input path="userId"/><br>
Name =<sf:input path="userName"/><br>
Email = <sf:input path="userEmail"/><br>
<input type = submit value ="sub"/>
</sf:form>
</body>
</html>