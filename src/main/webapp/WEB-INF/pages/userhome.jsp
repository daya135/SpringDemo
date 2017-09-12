<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>UserHome</title>
</head>
<body>
	<%
			String userName = (String) request.getSession().getAttribute("user");
	%>
	已登录用户:
	<%=userName%>
	<br>

	
</body>
</html>
