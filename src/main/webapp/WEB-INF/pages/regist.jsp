<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>regist</title>
</head>
<body>
	<form id="loginForm" action="${pageContext.request.contextPath}/action/regist" method="post">
		loginid:<input type="text" name="loginid" value="jzz"/><br>
		password:<input type="password" name="password" value="123"/><br>
		username:<input type="text" name="username" value="jzz"/><br>
		mobile:<input type="text" name="mobile" value="jzz"/><br>
		birthday:<input type="text" name="birthday" value="jzz"/><br>
		<input type="submit" value="regist"/>
	</form>
</body>
</html>