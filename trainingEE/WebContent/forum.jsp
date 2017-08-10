<%@page import="trainingEE.JDBChelper"%>
<%@page import="trainingEE.CMcomments" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>forum</title>
</head>
<body>

<canvas id="myCanvas"  width="400" height="150"> </canvas> 
<h1 style="font-size: 40px; font-weight:bold; text-align:center;">
 Blogs are whatever we make them. Defining Blog is a fool's errand!
</h1>
<p style="font-family: verdana; text-align: justify; ">
Guys Keep Sharing your views On Cars Here
</p>
<div>
<%
String username=(String)session.getAttribute("keyusername"); 
  if(username != null)
  {out.print("welcome"+" "+username);
  %>
<form action="forumservlet" method="post" id="commentform">
<textarea rows="4" cols="100" form="commentform" name="comment"></textarea>
<br/>
<input type="submit" name="commentbutton" value="post"> 
</form>
</div>
<% }
%>
<div>
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
</div>
<script type="text/javascript">

var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");

var gradient = ctx.createLinearGradient(0, 0, c.width, 0);
gradient.addColorStop("0", "red");
gradient.addColorStop("0.5", "orange");
gradient.addColorStop("1.0", "yellow");
ctx.font = "60px Verdana";
ctx.fillStyle = gradient;
ctx.fillText("Car Maniacs", 10, 90);
	
</script>
</body>
</html>