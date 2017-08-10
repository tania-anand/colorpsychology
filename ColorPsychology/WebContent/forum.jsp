<%@page import="trainingEE.JDBChelper"%>
<%@page import="trainingEE.CMcomments" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="blog.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>forum</title>
</head>
<body>
<div>
<%
  String username=(String)session.getAttribute("sessionU"); 
  if(username != null)
  {
%>
<h1>
<% out.print("welcome"+" "+username); %> 
</h1>
<% 
  }
%>


<%
JDBChelper helper=new JDBChelper();
helper.openConnection();


ArrayList<CMcomments> cmtlists=helper.retrievecomments();
for(CMcomments cmt:cmtlists){
	%>
	<h4> Posted By
	<%
	out.print(cmt.getUsername());
	%>
	</h4>
<p>
<% out.print(cmt.getComment());%>
</p>
<%	
}
%>
<%
if(username!=null)
{ 
String a ="10";
%>
<form action="forumservlet" method="post" id="commentform">
<textarea rows="4" cols="100" form="commentform" name="comment"></textarea>
<br/>
<input type="submit" name="commentbutton" value="post"> 
</form>
<%
session.setAttribute("sessionU",username);


}
%>

</div>





</body>
</html>