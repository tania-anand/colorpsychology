<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="nav.css">
<link rel="stylesheet" type="text/css" href="index.css"><title>Insert title here</title>
</head>
<body>
<h1>
  <%
  String username=(String)session.getAttribute("sessionU"); 
  if(username != null)
  {
	  out.print("welcome"+" "+username);
  }%>
 </h1>
<ul class="topnav" id="myTopnav">
  <li id="home"><a href="#home">Home</a></li>
  <li id="contact" onclick="contact.script"><a href="#contact">Contact</a></li>
  <li id="about"   onclick="about.script"><a href="#about">About</a></li>
  <%if(session.getAttribute("sessionU")!=null)
  {
  %>
  <li id="register"><a href="Logout">Logout</a></li>
  <li id="blog"><a href="">BLOG</a></li>
  <%
  }
  else
  {
  %>
   <li id="register"><a href="login1.jsp">Login</a></li>
   <li id="blog"><a href="">BLOG</a></li>
  <%
  }
  %>
  
</ul>
<img src="index.jpg" style="width:100%;height:500px">
<div id="i01">
Pick The Color
</div>
<table id="colorPick" width=100%>
<tr>
<td id="red"><a href="red/red.html">RED</a></td>
<td id="orange"><a href="orange/orange.html">ORANGE</a></td>
<td id="yellow"><a href="yellow/yellow.html">YELLOW</a></td>
</tr>
<tr>
<td id="blue"><a href="blue/blue.html">BLUE</a></td>
<td id="green"><a href="green/green.html">GREEN</a></td>
<td id="pink"><a href="pink/pink.html">PINK</a></td>
</tr>
<tr>
<td id="black" ><a href="black/black.html" style="color:rgb(255,255,255)">BLACK</a></td>
<td id="grey"><a href="grey/grey.html">GREY</a></td>
<td id="white" ><a href="white/white.html">WHITE</a></td>
</tr>
<table>


<div id="contact01" class="modal">
<!-- Modal content -->
<div class="contact-content">
<div class="close">&times;</div>
YOU CAN CONTACT US AT<br>
contact no:9780558923, 7890612345<br>
mail at psychologycolors@gmail.com<br>
</div>
</div>

<div id="about01" class="modal">
<div class="about-content">
<div class="close">&times;</div>
<img src="about1.png"><br>

To bring harmony and objective rationale to the use of colour in all aspects of life – easing the pain of<br>
colour selection, saving time, money and uncertainty, and empowering people to get colours right every time...<br>
with absolute confidence.<br>
</div>
</div>

<script>
// Get the modal
var modal = document.getElementById('contact01');
var modal1 = document.getElementById('about01');


// Get the button that opens the modal
var btn = document.getElementById("contact");
var btn1 = document.getElementById("about");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
var span1 = document.getElementsByClassName("close")[1];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block"
}
btn1.onclick = function() {
    modal1.style.display = "block"
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {

	modal.style.display = "none";
}
span1.onclick = function() {

	modal1.style.display = "none";
}


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
		modal1.style.display = "none";
    }
}
</script>



</body>
</html>