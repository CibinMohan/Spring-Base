<%@page import="antlr.BaseAST"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.dao.UserDao" %>
<%@ page import="com.domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
UserDao dao = (UserDao)context.getBean("dao");
User user = new User();
user.setUserId("sssww");
user.setUserName("Cibin");
user.setUserEmail("email");
dao.persist(user);
for(User u : dao.getAll(User.class))
{
	out.println("name:"+u.getUserName()+"email"+u.getUserEmail());	
}
%>
</body>
</html>