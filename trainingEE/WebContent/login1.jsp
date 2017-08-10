<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="login.css">
<title>Insert title here</title>
</head>
<body>
<form  align="center" method="POST" action="Login" >
<table align="center">
<tr>
<td>Login Id :</td>
<td><input type="text" name="login_name" required /></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="login_password"/></td>
</tr>
<tr>
<td colspan='2' style="padding-left:75px"><input id="button" type="submit" value="Login"></td>
</tr>
<tr>
<td colspan='2'><a href="form.html">New User? Register Here</a></td>
</tr>
</table>
</form>
</body>