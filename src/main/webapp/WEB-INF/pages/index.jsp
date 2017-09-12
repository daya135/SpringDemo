<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>HomePage</title>
</head>
<body>
		<%
				String userName = (String) request.getSession().getAttribute("user");
		%>
		已登录用户:<%=userName%>
		</br></br>
		<a href="${pageContext.request.contextPath}/ui/login">login</a><br/>
		<a href="${pageContext.request.contextPath}/ui/regist">regist</a><br/>
		<a href="${pageContext.request.contextPath}/ui/upload">upload</a><br/>
		<a href="${pageContext.request.contextPath}/ui/listfile">listfile</a><br/>
</body>
</html>
